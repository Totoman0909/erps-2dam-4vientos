package com.vaannila.dao;

import java.util.List;

import com.vaannila.domain.TipoTarea;

public interface TipoTareaDAO {

	public void guardarOActualizarTipoTarea(TipoTarea tipoTarea);
	public List<TipoTarea> listarTipoTareas();
	public TipoTarea listarTipoTareaPorId(Long id);
	public void eliminarTipoTarea(Long id);
}
