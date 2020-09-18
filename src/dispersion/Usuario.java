/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dispersion;

public class Usuario {

    private Usuarios users[];
    private final int TAM_TABLA = 20;

    public Usuario() {

        users = new Usuarios[TAM_TABLA];
        for (int i = 0; i < TAM_TABLA; i++) {
            users[i] = new Usuarios(0, "");
        }
    }

    public void setNombreDeUsuario(String nombre, int i) {
        users[i].setNombreDeUsuario(nombre);
    }

    public String getNombreDeUsuario(int i) {
        return users[i].getNombreDeUsuario();
    }

    public void setcontraseña(int codigo, int i) {
        users[i].setcontraseña(codigo);
    }

    public int getContraseña(int i) {
        return users[i].getContraseña();
    }

    public int getNumeroDeUsuarios() {
        return TAM_TABLA;
    }

    public int hash(int clave) {
        return clave % 19;
    }

    public boolean Insertar(int codigo, String nombre) {
        int pos, pos_sigte;
        pos = hash(codigo);

        if (getContraseña(pos) == 0) {
            setcontraseña(codigo, pos);
            setNombreDeUsuario(nombre, pos);

            return true;
        } else //Se produce colisión: Solución por reasignación por prueba lineal
        {
            pos_sigte = pos + 1;
            while (pos_sigte < getNumeroDeUsuarios()
                    && getContraseña(pos_sigte) != 0
                    && pos_sigte != pos) {
                pos_sigte++;
                if (pos_sigte == getNumeroDeUsuarios()) {
                    pos_sigte = 0;
                }

            }
            if (getContraseña(pos_sigte) == 0) {
                setcontraseña(codigo, pos_sigte);
                setNombreDeUsuario(nombre, pos_sigte);

                return true;
            } else {
                return false;
            }

        }
    }

    public int Buscar(int codigo) {
        int pos, pos_sigte;
        pos = hash(codigo);
        if (getContraseña(pos) == codigo) {
            return pos;
        } else //Se produce colisión: Solución por reasignación por prueba lineal
        {
            pos_sigte = pos + 1;
            while (pos_sigte < getNumeroDeUsuarios()
                    && getContraseña(pos_sigte) != 0
                    && pos_sigte != pos
                    && getContraseña(pos_sigte) != codigo) {
                pos_sigte++;
                if (pos_sigte == getNumeroDeUsuarios()) {
                    pos_sigte = 0;
                }

            }
            if (getContraseña(pos_sigte) == 0 || pos_sigte == pos) {
                return -1; //código no existe
            } else {
                return pos_sigte;
            }

        }
    }
}
