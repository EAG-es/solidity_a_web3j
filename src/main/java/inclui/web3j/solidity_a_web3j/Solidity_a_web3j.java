package inclui.web3j.solidity_a_web3j;

import inclui.formularios.clui_formularios;
import inclui.formularios.control_entradas;
import innui.modelos.configuraciones.ResourceBundles;
import innui.modelos.configuraciones.iniciales;
import innui.modelos.configuraciones.rutas;
import innui.modelos.errores.oks;
import innui.modelos.internacionalizacion.tr;
import innui.modelos.modelos;
import java.io.File;
import static java.lang.System.exit;
import java.util.ResourceBundle;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;

/**
 *
 * @author emilio
 */
public class Solidity_a_web3j extends iniciales {
    /** 
     * Ruta de los recursos de traducción para este paquete
     */
    public static String k_in_ruta = "in/inclui/web3j/solidity_a_web3j/in";  //NOI18N
    
    /**
     * Inicio de la aplicación
     * @param args 
     */
    public static void main(String[] args) {
        oks ok = new oks();
        Solidity_a_web3j solidity_a_web3j = null;
        try {
            solidity_a_web3j = new Solidity_a_web3j();
            solidity_a_web3j.run(ok);
        } catch (Exception e) {
            ok.setTxt(e);
        }
        if (ok.es == false) {
            System.err.println(ok.txt);
            exit(1);
        } else {
            exit(0);
        }
    }    
    /**
     * Inicio de la aplicación desde un objeto instanciado
     * @param ok Comunicar resultados
     * @param extras_array Opción de añadir parámetros en el futuro.
     * @return true si todo va bien
     * @throws Exception Opción de notificar errores de excepción
     */
    public boolean run(oks ok, Object ... extras_array) throws Exception {
        try {
            if (ok.es == false) { return ok.es; }
            ResourceBundle in = null;
            iniciar(ok);
            if (ok.es) { 
                in = ResourceBundles.getBundle(k_in_ruta);
                // Inicio del código propio de la aplicación
                // Fin del código propio de la aplicación
                oks ok_fin = new oks();
                escribir_linea(tr.in(in, "texto informativo"), ok, extras_array);
                terminar(ok_fin);
                if (ok_fin.es == false) {
                    ok.setTxt(ok.getTxt(), ok_fin.getTxt());
                }
            }
            return ok.es;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public boolean iniciar(oks ok, Object... extra_array) throws Exception {
        // Iniciar clase principal de la librería
        if (ok.es == false) { return ok.es; }
        _iniciar_desde_clase(modelos.class, ok);
        if (ok.es == false) { return ok.es; }
        _iniciar_desde_clase(this.getClass(), ok);
        return ok.es;
    }
    
    @Override
    public boolean terminar(oks ok, Object... extra_array) throws Exception {
        // Terminar clase principal de la librería
        if (ok.es == false) { return ok.es; }
        _terminar_desde_clase(modelos.class, ok);
        if (ok.es == false) { return ok.es; }
        _terminar_desde_clase(this.getClass(), ok);
        return ok.es;
    }
    
}
