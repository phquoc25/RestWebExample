package com.qph.repository;

import java.util.List;

import com.qph.model.UserDetails;

public interface IRepository<T> {

	public void save(T t);
	public void update(T t);
	public void delete(T t);
	public UserDetails findById(int userId);
	public List<T> getAll();
}
