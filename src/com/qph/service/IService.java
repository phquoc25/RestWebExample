package com.qph.service;

import java.util.List;

import com.qph.model.UserDetails;

public interface IService<T> {

	public void save(T t);

	public void update(T t);

	public void delete(T t);

	public T findById(int id);

	public List<T> getAll();
}
