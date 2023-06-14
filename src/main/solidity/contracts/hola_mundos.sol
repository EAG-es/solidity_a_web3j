// SPDX-License-Identifier: GPL-3.0

pragma solidity >=0.8.17;

import "./bases.sol";

/**
* Contrato "hola mundo""
*/
contract hola_mundos is bases {    
    /**
    * Devuelve el mensaje "Hola mundo"
    */
    function leer () public virtual view 
    si_activo 
    returns (string memory) {
        return unicode"Hola mundo";
    }

}