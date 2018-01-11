package ${pkg}.service

import ${pkg}.domain.Manufacturer
import groovy.transform.CompileStatic
import org.springframework.stereotype.Service

@CompileStatic
@grails.gorm.services.Service(Manufacturer)
@Service
interface ManufacturerService {
    List<Manufacturer> findAll()
}