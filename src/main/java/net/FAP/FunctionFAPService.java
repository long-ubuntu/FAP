package net.FAP;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FunctionFAPService {
	@Autowired
	private FunctionFAPRepository repo;
	
	public List<FunctionFAP> listAll() {		
		return repo.findAll();
	}
	
	public void save(FunctionFAP FunctionFAP) {
		repo.save(FunctionFAP);
	}
	
	public FunctionFAP get(Long id) {
		return repo.findById(id).get();
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}
}
