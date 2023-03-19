package kodlama.io.rentACar.business.concrtes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import kodlama.io.rentACar.business.abstracts.ModelService;
import kodlama.io.rentACar.business.response.GetAllModelsResponse;
import kodlama.io.rentACar.business.response.GetByIdModelResponse;
import kodlama.io.rentACar.business.resquests.CreateModelRequest;
import kodlama.io.rentACar.business.resquests.UpdateModelRequest;
import kodlama.io.rentACar.business.rules.ModelBusinessRules;
import kodlama.io.rentACar.core.utilities.mappers.ModelMapperService;
import kodlama.io.rentACar.dataAccess.abstracts.ModelRepository;
import kodlama.io.rentACar.entities.Model;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ModelManager implements ModelService {

	private ModelRepository modelRepository;
	private ModelMapperService modelMapperService;
	private ModelBusinessRules modelBusinessRules;

	@Override
	public List<GetAllModelsResponse> getAll() {
		List<Model> models = modelRepository.findAll();

		List<GetAllModelsResponse> modelsResponses = models.stream()
				.map(model -> this.modelMapperService.forResponse().map(model, GetAllModelsResponse.class))
				.collect(Collectors.toList());
		return modelsResponses;
	}

	@Override
	public void add(CreateModelRequest createModelRequest) {
		this.modelBusinessRules.checkIfBrandNameExists(createModelRequest.getName());
		
		Model model=this.modelMapperService.forRequest().map(createModelRequest, Model.class);
		model.setId(0);
		this.modelRepository.save(model);
	}

	@Override
	public void update(UpdateModelRequest updatemodelRequest) {
		Model model= this.modelMapperService.forRequest().map(updatemodelRequest, Model.class);
		this.modelRepository.save(model);
		
	}

	@Override
	public void delete(int id) {
		this.modelRepository.deleteById(id);		
	}

	@Override
	public GetByIdModelResponse getById(int id) {
		Model model=this.modelRepository.findById(id).orElseThrow();
		GetByIdModelResponse getByIdModelResponse=this.modelMapperService.forResponse().map(model, GetByIdModelResponse.class);
		return getByIdModelResponse;
		
	}

}
