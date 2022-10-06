//
// Created by destr on 16.09.2020.
//

#include "DataOfIni.h"

void DataOfIni::insert (const std::string& sectionName, const std::map<std::string, std::string>& parameterAndValue) {
    tripleMap.insert(std::make_pair(sectionName, parameterAndValue));
}

bool DataOfIni::find (const std::string& sectionName, const std::string& parametersName, std::string& result) const {
    if (tripleMap.find(sectionName)->second.find(parametersName)->first == parametersName) {
        result += tripleMap.find(sectionName)->second.find(parametersName)->second;
        return true;
    } else {
        return false;
    }
}

void DataOfIni::print (const std::string& sectionName, std::string parametersName) const {
    std::cout << sectionName << std::endl << parametersName << " = " << tripleMap.find(sectionName)
    ->second.find(parametersName)->second;
}

void DataOfIni::printAll () {
    for(const auto & ptr : tripleMap) {
        std::cout << ptr.first << std::endl;
        for(const auto & eptr : ptr.second){
            std::cout << eptr.first << " = " << eptr.second << std::endl;
        }
    }
}