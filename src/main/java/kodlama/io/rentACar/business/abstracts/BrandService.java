package kodlama.io.rentACar.business.abstracts;

import java.util.List;

import kodlama.io.rentACar.business.response.GetAllBrandsResponse;
import kodlama.io.rentACar.business.response.GetByIdBrandResponse;
import kodlama.io.rentACar.business.resquests.CreateBrandRequest;
import kodlama.io.rentACar.business.resquests.UpdateBrandRequest;

public interface BrandService {

	List<GetAllBrandsResponse> getAll();
	void add(CreateBrandRequest createBrandRequest);
	void update(UpdateBrandRequest updateBrandRequest);
	void delete(int id);
	GetByIdBrandResponse getById(int id);
}
