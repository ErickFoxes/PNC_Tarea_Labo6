package com.uca.capas.dao;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.uca.capas.domain.Contribuyente;

@Repository
public class ContribuyenteDAOImpl implements ContribuyenteDAO{
	
	@Autowired
	ImportanciaDAO importanciaDAO;
	
	@PersistenceContext(unitName="capas")
	private EntityManager entityManager;
	
	@Override
	public List<Contribuyente> findAll() throws DataAccessException {
		StringBuffer sb = new StringBuffer();
		sb.append("select * from public.contribuyente");
		Query query = entityManager.createNativeQuery(sb.toString(), Contribuyente.class);

		List<Contribuyente> res = query.getResultList();
		return res;
	}


	@Transactional
	public void save(Contribuyente contribuyente) throws DataAccessException {
		LocalDate hoy = LocalDate.now();
		contribuyente.setFfecha_ingreso(hoy);
		contribuyente.setCimportancia(importanciaDAO.findOne(contribuyente.getC_importancia()));
		entityManager.persist(contribuyente);
	}
}
