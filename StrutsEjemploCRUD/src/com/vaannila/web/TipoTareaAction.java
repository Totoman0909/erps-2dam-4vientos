package com.vaannila.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.vaannila.dao.UserDAO;
import com.vaannila.dao.UserDAOImpl;
import com.vaannila.dao.TipoTareaDAO;
import com.vaannila.dao.TipoTareaDAOImpl;
import com.vaannila.domain.Tarea;
import com.vaannila.domain.TipoTarea;

public class TipoTareaAction extends ActionSupport implements ModelDriven<TipoTarea> {

	private static final long serialVersionUID = -6659924552566640539L;

	/*	
	 * 	public void guardarOActualizarTipoTarea(TipoTarea tipoTarea);
	public List<TipoTarea> listarTipoTareas();
	public TipoTarea listarTipoTareaPorId(Long id);
	public void eliminarTipoTarea(Long id);
*/
	
	private TipoTarea tipoTarea = new TipoTarea();
	private List<TipoTarea> listaTipoTareas = new ArrayList<TipoTarea>();
	private TipoTareaDAO tipoTareaDAO = new TipoTareaDAOImpl();
	
	@Override
	public TipoTarea getModel() {
		return tipoTarea;
	}
	
	/**
	 * To save or update user.
	 * @return String
	 */
	public String guardarOActualizar()
	{	
		tipoTareaDAO.guardarOActualizarTipoTarea(tipoTarea);
		return SUCCESS;
	}
	
	/**
	 * To list all users.
	 * @return String
	 */
	public String listar()
	{
		listaTipoTareas = tipoTareaDAO.listarTipoTareas();
		return SUCCESS;
	}
	
	/**
	 * To delete a user.
	 * @return String
	 */
	public String eliminar()
	{
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		tipoTareaDAO.eliminarTipoTarea(Long.parseLong(request.getParameter("id")));
		return SUCCESS;
	}
	
	/**
	 * To list a single user by Id.
	 * @return String
	 */
	public String editar()
	{
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		tipoTarea = tipoTareaDAO.listarTipoTareaPorId(Long.parseLong(request.getParameter("id")));
		return SUCCESS;
	}
	
	public TipoTarea getTipoTarea() {
		return tipoTarea;
	}

	public void setTipoTarea(TipoTarea tipoTarea) {
		this.tipoTarea = tipoTarea;
	}

	public List<TipoTarea> getListaTipoTareas() {
		return listaTipoTareas;
	}

	public void setListaTipoTareas(List<TipoTarea> listaTipoTareas) {
		this.listaTipoTareas = listaTipoTareas;
	}

}
