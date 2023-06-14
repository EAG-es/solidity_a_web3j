// SPDX-License-Identifier: GPL-3.0

pragma solidity >=0.8.17;

import "./libs/lib_bases.sol";
/**
* Estructura para el control de usuarios
*/
struct acls {
    /// Dirección EAO
    address direccion;
    /// Texto que identifica al usuario, y que es necesario para poder cambiar su dirección
    string usuario;
    /// código sha256 de la clave secreta del usuario
    bytes32 clave;
    /// Array con los permisos ACL
    bytes32 [] permisos_array;
}
bytes32 constant k_permiso_maximo = "permiso_maximo";
bytes32 constant k_permiso_minimo = "permiso_minimo";

enum estados {
    activo, inactivo, limitado
}
/**
* Contrato normalizado con administradores, permisos y clave.
*/
contract bases {    
    /**
    * Array acl, con las direcciones de los administradores
    */
    acls [] public acl_array;
    /**
    * Estado del contrato. 
    */
    estados public estado = estados.inactivo;

    constructor () {
        acls memory acl;
        acl.direccion = msg.sender;
        acl. usuario = "root";
        acl.clave = sha256("root_clave");
        acl.permisos_array = new bytes32[](1);
        acl.permisos_array[0] = k_permiso_maximo;
        acl_array.push(acl);
    }
    /**
    * Rquiere que el estado sea activo
    */
    modifier si_activo {
        require(estado == estados.activo, unicode"El contrato no está activo.");
        _;
    }
    /**
    * Requiere que el estado sea activo o limitado
    */
    modifier si_activo_o_limitado {
        require(estado == estados.activo || estado == estados.limitado
        , unicode"El contrato no está activo o no está limitado.");
        _;
    }
    /**
    * Requiere que el estado limitado
    */
    modifier si_limitado {
        require(estado == estados.limitado, unicode"El contrato no está limitado.");
        _;
    }
    /**
    * Comprueba que una dirección sea de administrador
    * @param direccion La dirección que comprobar
    * @return true si la dirección es de administrador, false en caso contrario
    */
    function ser_administrador(address direccion) public virtual view 
    returns (bool){
        bool es_encontrado = false;
        uint i = 0;
        while (true) {
            if (i >= acl_array.length) {
                break;
            }
            if (direccion == acl_array[i].direccion) {
                es_encontrado = true;
                break;
            }
            i = i + 1;
        }
        return es_encontrado;
    }
    /**
    * Requiere un administrador
    */
    modifier si_administrador {
        address direccion = msg.sender;
        require(ser_administrador(direccion), unicode"La direccion no es de un administrador.");
        _;
    }
    /**
    * Comprueba que una dirección sea de administrador y que tiene el permiso requerido
    * @param direccion La dirección que comprobar
    * @param permiso_necesario Un texto que coincida con el alguno de los permisos de esa dirección
    * @return true si la dirección es de administrador, false en caso contrario
    */
    function ser_administrador_con_permiso (address direccion, bytes32 permiso_necesario) public virtual view 
    returns (bool) {
        bool es_encontrado = false;
        int i = 0;
        i = leer_administrador_pos(direccion);
        uint u;
        uint uu = 0;
        if (i >= 0) {
            u = uint(i);
            uu = 0; 
            while (true) {
                if (uu >= acl_array[u].permisos_array.length) {
                    break;
                }
                if (acl_array[u].permisos_array[uu] == permiso_necesario) {
                    es_encontrado = true;
                    break;
                }
                uu = uu + 1;
            }
        }
        return es_encontrado;
    }
    /**
    * Comprueba que una dirección sea de administrador y que tiene alguno de los permisos requeridos
    * @param direccion La dirección que comprobar
    * @param permisos_posibles_array Array de permisos, con tener uno solo sería suficiente.
    * @return true si la dirección es de administrador, false en caso contrario
    */
    function ser_administrador_con_algun_permiso (address direccion, bytes32 [] memory permisos_posibles_array) public virtual view 
    returns (bool) {
        bool es_correcto = false;
        uint tam = permisos_posibles_array.length;
        uint u = 0;
        while (true) {
            if (u >= tam) {
                break;
            }
            if (ser_administrador_con_permiso(direccion, permisos_posibles_array[u])) {
                es_correcto = true;
                break;
            }
            u = u + 1;
        }
        return es_correcto;
    }
    /**
    * Comprueba que una dirección sea de administrador y que tiene todos los permisos requeridos
    * @param direccion La dirección que comprobar
    * @param permisos_exigidos_array Array de permisos, con tener uno solo sería suficiente.
    * @return true si la dirección es de administrador, false en caso contrario
    */
    function ser_administrador_con_todo_permiso (address direccion, bytes32 [] memory permisos_exigidos_array) public virtual view 
    returns (bool) {
        bool es_correcto = true;
        uint tam = permisos_exigidos_array.length;
        uint u = 0;
        while (true) {
            if (u >= tam) {
                break;
            }
            if (ser_administrador_con_permiso(direccion, permisos_exigidos_array[u]) == false) {
                // string memory texto = string.concat(unicode"Permiso no encontrado: "
                // , textos_bases.convertir_bytes32_a_string(permisos_exigidos_array[u]));
                // require(false, texto);
                es_correcto = false;
                break;
            }
            u = u + 1;
        }
        return es_correcto;
    }
    /**
    * Requiere un administrador con un permiso determinado
    * @param permiso_necesario Permiso que debe poseer ese administrador
    */
    modifier si_administrador_con_permiso (bytes32 permiso_necesario) {
        address direccion = msg.sender;
        string memory texto;
        texto = textos_bases.convertir_bytes32_a_string(permiso_necesario);
        require(ser_administrador_con_permiso(direccion, permiso_necesario)
        , string.concat(unicode"La direccion no es de un administrador o no tiene el permiso solicitado: "
        , texto));
        _;
    }
    /**
    * Requiere un administrador con un alguno de los permisos determinados
    * @param permisos_necesarios_array Permiso que debe poseer ese administrador
    */
    modifier si_administrador_con_algun_permiso (bytes32 [] memory permisos_necesarios_array) {
        address direccion = msg.sender;
        require(ser_administrador_con_algun_permiso(direccion, permisos_necesarios_array)
        , unicode"La direccion no es de un administrador o no tiene alguno de los permisos solicitados. ");
        _;
    }
    /**
    * Requiere un administrador con todos los permisos determinados
    * @param permisos_necesarios_array Permiso que debe poseer ese administrador
    */
    modifier si_administrador_con_todo_permiso (bytes32 [] memory permisos_necesarios_array) {
        address direccion = msg.sender;
        require(ser_administrador_con_todo_permiso(direccion, permisos_necesarios_array)
        , unicode"La direccion no es de un administrador o no tiene alguno de los permisos solicitados. ");
        _;
    }
    /**
    * Comprueba que la clave de una dirección de administrador coincide con la clave enviada
    * @param direccion La dirección que comprobar
    * @param clave Texto que encriptar SHA256 y cotejar con la clave de la dirección
    * @return true si la dirección es de administrador, false en caso contrario
    */
    function comprobar_clave(address direccion, bytes memory clave) public virtual view 
    returns (bool) {
        int i;
        i = leer_administrador_pos(direccion);
        require(i >= 0, unicode"La direccion no es de un administrador. ");
        return (acl_array[uint(i)].clave == sha256(clave));
    }
    /**
    * Activa el contrato
    */
    function activar() public virtual 
    si_administrador {
        estado = estados.activo;
    }
    /**
    * Inactiva el contrato
    */
    function inactivar() public virtual
    si_administrador {
        estado = estados.inactivo;
    }
    /**
    * Pone en contrato en un estado limitado.
    */
    function limitar() public virtual
    si_administrador {
        estado = estados.limitado;
    }
    /**
    * Crea un nuevo administrador
    * @param direccion Dirección de cuenta EAO
    * @param usuario Nombre de usuario
    * @param clave Clave que se guarda codificada con SHA256
    * @param permisos_array Array de texto libre para comprobar permisos (puede usarse k_maximo_permiso).
    * Ejemplo de parámetros desde remix: 0x6f24CA95cF4814025b8Ff6ED76E490b353abFDFd, "ejemplo", 0x0x656a656d706c6f61736369696162797465733332, []
    */
    function crear_administrador(address direccion, string memory usuario, bytes memory clave, bytes32[] memory permisos_array) public virtual
    si_administrador {
        bool es_encontrado = false;
        uint i = 0;
        while (true) {
            if (i >= acl_array.length) {
                break;
            }
            if (direccion == acl_array[i].direccion) {
                es_encontrado = true;
                break;
            }
            i = i + 1;
        }
        require(es_encontrado == false, unicode"Esa dirección de administrador ya está registrada. ");
        acls memory acl;
        acl.direccion = direccion;
        acl. usuario = usuario;
        acl.clave = sha256(clave);
        acl.permisos_array = permisos_array;
        acl_array.push(acl);
    }
    /**
    * Devuelve la posición de un administrador en el acl_array de administradores
    * @param direccion Dirección de cuenta EAO del nuevo administrador
    * @return la posición en acl_array o -1 si no está en él
    */
    function leer_administrador_pos(address direccion) public view virtual
    returns (int) {
        bool es_encontrado = false;
        uint i = 0;
        while (true) {
            if (i >= acl_array.length) {
                break;
            }
            if (direccion == acl_array[i].direccion) {
                es_encontrado = true;
                break;
            }
            i = i + 1;
        }
        if (es_encontrado) {
            return int(i);
        } else {
            return -1;
        }
    }
    /**
    * Devuelve el registro acl de un administrador, con la clave invalidada con *'s
    * @param pos Posición en acls_array
    * @return Un array de Bytes32
    */
    function leer_administrador_permisos_array(int pos) public view virtual
    returns (bytes32 [] memory) {
        require(pos >= 0, unicode"La posición no puede ser negativa. ");
        uint tam_u = acl_array.length;
        int tam = int(tam_u);
        require(pos < tam, unicode"La posición supera los elementos del array. ");
        return acl_array[uint(pos)].permisos_array;
    }
    /**
    * Actualiza el acl de administrador, por su dirección.
    * Si tiene permiso_maximo puede cambiar la clave (debe llegar ya codificada con sha256) y dar permiso_maximo
    * @param direccion Direccióbn del administrador que actualizar
    * @param permisos_array Array con los nuevos permisos que poner.
    */
    function actualizar_administrador_permisos_array(address direccion, bytes32 [] memory permisos_array) public virtual
    si_administrador {
        int i = 0;
        i = leer_administrador_pos(direccion);
        require(i >= 0, unicode"La direccion no es de un administrador. ");
        uint u = uint(i);
        u = 0;
        bool es_cambiar_permisos = false;
        // string memory debug_tex = unicode"Inicio de la búsqueda de permiso_maximo. ";
        while (true) {
            if (u >= permisos_array.length) {
                break;
            }
            if (permisos_array[u] == k_permiso_maximo) {
                // debug_tex = string.concat(unicode"Encontrado permiso_maximo. ", debug_tex);
                bool es_administrador_con_permiso = ser_administrador_con_permiso(msg.sender, k_permiso_maximo);
                require(es_administrador_con_permiso
                , unicode"No puede poner permiso_maximo; si quien lo pide, no lo posee. ");
                break;
            }
            u = u + 1;
        }        
        if (ser_administrador_con_permiso(direccion, k_permiso_maximo)) {
            // debug_tex = string.concat(unicode"Se van a cambiar permisos a un administrador con permiso_maximo. ", debug_tex);
            if (ser_administrador_con_permiso(msg.sender, k_permiso_maximo)) { 
                // debug_tex = unicode"El solicitante tiene permiso_maximo. ";
                es_cambiar_permisos = true;
            } else {
                require(false, "Solo un administrador con permiso_maximo puede dar permisos a un administrador con permiso_maximo. ");
            }
        } else {
            // debug_tex = string.concat(unicode"Se van a cambiar permisos a un administrador que no tiene permiso_maximo. ", debug_tex);
            es_cambiar_permisos = true;
        }
        if (es_cambiar_permisos) {
            acl_array[uint(i)].permisos_array = permisos_array;
//            uint tam_permisos = permisos_array.length;
//            uint uu = 0;
//            debug_tex = string.concat(unicode"Se van a borrar todos los permisos. ", debug_tex);
//            borrar_permisos(u);
//            while (true) {
//                if (uu >= tam_permisos) {
//                    break;
//                }
//                debug_tex = string.concat(unicode"Se añade un nuevo permiso. ", debug_tex);
//                acl_array[uint(i)].permisos_array.push(permisos_array[uu]);
//                uu = uu + 1;
//            }
        }
    }
    /**
    * Actualiza el usuario, la clave y la dirección de un administrador
    * @param usuario Nuevo usuario que poner (si está vacia no se actualiza)
    * @param clave Clave que actualizar (si está vacia no se actualiza)
    * @param nueva_direccion Dirección que actualizar  (si es 0 no se actualiza)
    */
    function actualizar_administrador_usuario_clave_direccion(string memory usuario, bytes memory clave, address nueva_direccion) public virtual
    si_administrador {
        address direccion = msg.sender;
        int i = 0;
        i = leer_administrador_pos(direccion);
        require(i >= 0, unicode"La direccion no es de un administrador. ");
        if (bytes(usuario).length > 0) {
            acl_array[uint(i)].usuario = usuario;
        }
        if (bytes(clave).length > 0) {
            acl_array[uint(i)].clave = sha256(clave);
        }
        if (nueva_direccion != address(0)) {
            acl_array[uint(i)].direccion = nueva_direccion;
        }
    }
    /**
    * Actualiza el usuario, la clave y la dirección de un administrador
    * @param usuario Nuevo usuario que poner (si está vacia no se actualiza)
    * @param clave Clave que actualizar (si está vacia no se actualiza)
    * @param nueva_direccion Dirección que actualizar  (si es 0 no se actualiza)
    */
    function actualizar_administrador_usuario_clave_direccion(address direccion, string memory usuario, bytes memory clave, address nueva_direccion) public virtual
    si_administrador_con_permiso (k_permiso_maximo) {
        int i = 0;
        i = leer_administrador_pos(direccion);
        require(i >= 0, unicode"La direccion no es de un administrador. ");
        if (bytes(usuario).length > 0) {
            acl_array[uint(i)].usuario = usuario;
        }
        if (bytes(clave).length > 0) {
            acl_array[uint(i)].clave = sha256(clave);
        }
        if (nueva_direccion != address(0)) {
            acl_array[uint(i)].direccion = nueva_direccion;
        }
    }
    /**
    * Borra un administrador
    * @param direccion Dirección de cuenta EAO que eliminar
    */
    function borrar_administrador(address direccion) public virtual 
    si_administrador_con_permiso (k_permiso_maximo) {
        int i;
        i = leer_administrador_pos(direccion);
        require(i >= 0, unicode"La direccion no es de un administrador. ");
        acl_array[uint(i)] = acl_array[acl_array.length - 1];
        acl_array.pop();
    }

}