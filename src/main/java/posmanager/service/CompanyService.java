//package posmanager.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//import org.springframework.stereotype.Service;
//import posmanager.CompanyDetails;
//import posmanager.repository.CompanyRepository;
//
//import java.util.List;
//
//@Service
//public class CompanyService {
//    @Autowired
//    CompanyRepository companyRepository;
//
//    public void saveCompany(CompanyDetails companyDetails)
//    {
//        companyRepository.save(companyDetails);
//    }
//    public boolean existsByCode(String code)
//    {
//        return companyRepository.existsByCode(code);
//    }
//    public List<CompanyDetails> companyList()
//    {
//        return companyRepository.findAll();
//    }
//
//    public void deleteCompany(int id)
//    {
//        companyRepository.delete(id);
//    }
//
//    public CompanyDetails getCompany(int id)
//    {
//        return companyRepository.getOne(id);
//    }
//
//
//}
