package com.example.testtask.data_source.local

import androidx.lifecycle.MutableLiveData
import androidx.room.Room
import com.example.testtask.data.Employee
import com.example.testtask.data.Speciality
import com.example.testtask.data_source.local.room.RoomDB

class LocalDataSource (val roomDB: RoomDB){

    val employees = roomDB.employeesDao().getEmployeesLiveData()
    val specialities = roomDB.specialitiesDao().getSpecialitiesLiveData()

    fun updateEmployees(employees: List<Employee>){
        roomDB.employeesDao().deleteAll()
        for (employee in employees)
            roomDB.employeesDao().insert(employee)
    }

    fun updateSpescialities(spescialities: List<Speciality>){
        roomDB.specialitiesDao().deleteAll()
        for (speciality in spescialities)
            roomDB.specialitiesDao().insert(speciality)
    }
}