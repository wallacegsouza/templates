package ${pkg}.init

import ${pkg}.domain.Manufacturer
import ${pkg}.domain.Vehicle
import grails.gorm.transactions.Transactional
import groovy.transform.CompileStatic
import org.springframework.stereotype.Component

@Component
@CompileStatic
class BootStrap {

    @Transactional
    void init() {
        Manufacturer audi = new Manufacturer(name: 'audi')
        audi.addToVehicles(new Vehicle(name: 'A3', year: 1996))
        audi.addToVehicles(new Vehicle(name: 'A4', year: 1994))
        audi.save()

        Manufacturer ford = new Manufacturer(name: 'ford')
        ford.addToVehicles(new Vehicle(name: 'Ford KA', year: 1996))
        ford.save()
    }
}
