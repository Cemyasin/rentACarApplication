//package kodlama.io.rentACar.dataAccess.concretes;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//import kodlama.io.rentACar.dataAccess.abstracts.BrandRepository;
//import kodlama.io.rentACar.entities.Brand;
//
//@Repository
//public class InMemoryBrandRepository implements BrandRepository {
//
//	List<Brand> brands;
//
//	@Autowired
//	public InMemoryBrandRepository() {
//		brands=new ArrayList<Brand>();
//		brands.add(new Brand(1,"BMW"));
//		brands.add(new Brand(2,"Merso"));
//		brands.add(new Brand(3,"Audi"));
//		brands.add(new Brand(4,"Opel"));
//		brands.add(new Brand(5,"Tofaşk"));
//		brands.add(new Brand(6,"Honda"));
//	}
//
//	@Override
//	public List<Brand> getAll() {
//		return brands;
//	}
//
//}
