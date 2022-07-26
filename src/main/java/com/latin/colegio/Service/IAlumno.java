package com.latin.colegio.Service;

import com.latin.colegio.Model.Alumno;
import java.util.ArrayList;

/**
 *
 * @author Sandoval
 */
public interface IAlumno {
    public ArrayList<Alumno> list();
    public void create(Alumno alumno);
    public void update(Alumno alumno);
    public void delete(int codigo);
}
