package com.vaannila.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.googlecode.s2hibernate.struts2.plugin.annotations.SessionTarget;
import com.googlecode.s2hibernate.struts2.plugin.annotations.TransactionTarget;
import com.vaannila.domain.TipoTarea;


public class TipoTareaDAOImpl implements TipoTareaDAO {
	
	@SessionTarget
	Session session;
	
	@TransactionTarget
	Transaction transaction;
	
/*
 	public void guardarOActualizarTipoTarea(TipoTarea tipoTarea);
	public List<TipoTarea> listarTipoTareas();
	public TipoTarea listarTareaPorId(Long id);
	public void eliminarTipoTarea(Long id);
*/
	/**
	 * Used to save or update a user.
	 */
	@Override
	public void guardarOActualizarTipoTarea(TipoTarea tipoTarea) {
		try {
			session.saveOrUpdate(tipoTarea);
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}

	/**
	 * Used to delete a user.
	 */
	@Override
	public void eliminarTipoTarea(Long id) {
		try {
			TipoTarea tipoTarea = (TipoTarea) session.get(TipoTarea.class, id);
			session.delete(tipoTarea);
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		} 
	}
	
	/**
	 * Used to list all the users.
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<TipoTarea> listarTipoTareas() {
		List<TipoTarea> tipoTareas = null;
		try {
			tipoTareas = session.createQuery("from TipoTarea").list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tipoTareas;
	}

	/**
	 * Used to list a single user by Id.
	 */
	@Override
	public TipoTarea listarTipoTareaPorId(Long id){
		TipoTarea tipoTarea = null;
		try {
			tipoTarea = (TipoTarea) session.get(TipoTarea.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tipoTarea;
	}

}
