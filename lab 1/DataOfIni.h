//
// Created by destr on 16.09.2020.
//

#ifndef OOP_LABORATORY_WORK_1_DATAOFINI_H
#define OOP_LABORATORY_WORK_1_DATAOFINI_H


#include <iostream>
#include <vector>
#include <string>
#include <map>

class DataOfIni {
public:
    DataOfIni() = default;

    bool find(const std::string&, const std::string&, std::string&) const;

    void insert (const std::string&, const std::map<std::string, std::string>&);

private:
    std::map<std::string, std::map<std::string, std::string>> tripleMap;

    //std::vector<std::string, std::pair<std::string, std::string>> tripleVector;

    void print(const std::string&, std::string) const;

    void printAll();
};


#endif //OOP_LABORATORY_WORK_1_DATAOFINI_H
