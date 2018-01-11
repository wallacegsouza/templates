package ${pkg}.service

import ${pkg}.domain.Manufacturer
import ${pkg}.domain.Vehicle
import grails.gorm.services.Where
import groovy.transform.CompileStatic
import org.springframework.stereotype.Service

@CompileStatic
@grails.gorm.services.Service(Vehicle)
@Service
interface VehicleService {

    @Where({ manufacturer.name == manufacturerName })
    List<Vehicle> findAllByManufacturer(String manufacturerName)

}