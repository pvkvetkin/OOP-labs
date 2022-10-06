//
// Created by destr on 16.09.2020.
//

#ifndef OOP_LABORATORY_WORK_1_FILEPROCESSING_H
#define OOP_LABORATORY_WORK_1_FILEPROCESSING_H


#include "DataOfIni.h"
#include <string>
#include <vector>
#include <fstream>
#include <iostream>

class FileProcessing {
public:
    explicit FileProcessing(std::string&);

    std::string getString(std::string nameSection, const std::string &parameter) const;

    int getInt(std::string, const std::string&) const;

    float getFloat(std::string, const std::string&) const;

private:
    DataOfIni object;

    void parserFunction(std::string &input_);

    std::string findValue(const std::string&, const std::string&, std::string&) const;
};

#endif //OOP_LABORATORY_WORK_1_FILEPROCESSING_H
