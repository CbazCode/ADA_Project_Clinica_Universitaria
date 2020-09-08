/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dispersion;
public class Usuarios {
private String nombreDeUsuario;
private int contraseña;

public Usuarios(int codigo, String nombre)
{
contraseña = codigo;
nombreDeUsuario = nombre;

}

public void setNombreDeUsuario(String nombre)
{
nombreDeUsuario = nombre;
}

public String getNombreDeUsuario()
{
return nombreDeUsuario;
}
public void setcontraseña(int codigo)
{
contraseña = codigo;
}
public int getContraseña()
{
return contraseña;
}

}

