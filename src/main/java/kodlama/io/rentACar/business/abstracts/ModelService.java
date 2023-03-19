package kodlama.io.rentACar.business.abstracts;

import java.util.List;

import kodlama.io.rentACar.business.response.GetAllModelsResponse;
import kodlama.io.rentACar.business.response.GetByIdModelResponse;
import kodlama.io.rentACar.business.resquests.CreateModelRequest;
import kodlama.io.rentACar.business.resquests.UpdateModelRequest;

public interface ModelService {
	
	List<GetAllModelsResponse> getAll();
	void add(CreateModelRequest createModelRequest);
	void update(UpdateModelRequest modelRequest);
	void delete(int id);
	GetByIdModelResponse getById(int id);
	
}
