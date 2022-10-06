//
// Created by destr on 16.09.2020.
//

#include <regex>
#include <functional>
#include "DataOfIni.h"
#include "FileProcessing.h"

FileProcessing::FileProcessing(std::string& input_) {
    parserFunction(input_);
}

void FileProcessing::parserFunction(std::string &input_) {
    std::string onlyName, onlyFormat;
    std::string badName = " ";
    for (int i = 0; i < input_.length(); ++i) {
        if (i >= input_.length() - 4) {
            onlyFormat += input_[i];
            continue;
        }
        onlyName += input_[i];
    }
    std::ifstream inFile(onlyName + onlyFormat);
    std::string someString, s;
    std::vector<std::string> sections;
    std::map<std::string, std::string> parameterAndValue;
    int iteration = 0;
    if (!inFile.is_open()) {
        throw std::runtime_error("File is not open");
    } else if (!std::regex_match(onlyName + onlyFormat, std::regex(("[\\w]*\\.ini")))) {
        throw std::runtime_error("Bad grammar of files name");
    } else {
        while (std::getline(inFile, someString)) {
            if (someString.empty() && iteration == 0) {
                throw std::runtime_error("Bad arguments in file");
            } else if (someString[0] == '\0' || someString[0] == ';') {
                    continue;
            } else if (someString[0] == '[') {
                int indexLast = 0;
                std::string sectionName = "[";
                bool exc = false;
                for (int i = 1; i < someString.length(); ++i) {
                    if (someString[i] == ']') {
                        indexLast = i;
                        exc = true;
                        break;
                    }
                }
                if (!exc) {
                    throw std::runtime_error("Bad argument in file");
                }
                for (int i = 1; i < indexLast; ++i) {
                    sectionName += someString[i];
                }
                sectionName += "]";
                ++iteration;
                if (!std::regex_match(sectionName, std::regex(R"([\[\w]*\])"))) {
                    throw std::runtime_error("Bad grammar of sections name");
                }
                sections.push_back(sectionName);
                object.insert(sections[sections.size() - 2], parameterAndValue);
                parameterAndValue.clear();
//                if (iterations > 0) {
//                    object.insert(sections[sections.size() - 2], parameterAndValue);
//                    parameterAndValue.clear();
//                }
            } else {
                std::string parametersName, parametersValue;
                int indexEqual = 0;
                bool flagEx = false;
                for (int i = 0; i < someString.length(); ++i) {
                    if (someString[i] == '=') {
                        indexEqual = i;
                        flagEx = true;
                        break;
                    }
                }
                if (someString[indexEqual + 1] != ' ') {
                    throw std::runtime_error("Value not found");
                }
                if (!flagEx) {
                    throw std::runtime_error("Value not found");
                }
                for (int i = 0; i < indexEqual - 1; ++i) {
                    parametersName += someString[i];
                }
                for (int i = indexEqual + 1; i < someString.length(); ++i) {
                    if (someString[i] != ' ') {
                        parametersValue += someString[i];
                    } else if (someString[i] == ' ' && someString[i + 1] == ';') {
                        break;
                    }
                }
                if (!std::regex_match(parametersName, std::regex("[\\w]*"))) {
                    throw std::runtime_error("Bad grammar of paramaters name");
                }
                parameterAndValue[parametersName] = parametersValue;
//                if(sections[iterations] != sections[iterations - 1] && iterations != 0) {
//                    object.insert(sections[sections.size() - 1], parameterAndValue);
//                }
            }
        }
    }
    object.insert(sections[sections.size() - 1], parameterAndValue);
    inFile.close();
}

std::string FileProcessing::findValue(const std::string& nameSection, const std::string& parameter,
                                      std::string& result) const {
    if (object.find(nameSection, parameter, result)) {
        return result;
    } else {
        throw std::runtime_error("Wrong section or parameter");
    }
}

std::string FileProcessing::getString(std::string nameSection, const std::string& parameter) const {
    nameSection.insert(0, "[");
    nameSection.insert(nameSection.length(), "]");
    std::string result;
    std::string mainValue = findValue(nameSection, parameter, result);
    if(std::regex_match(result, std::regex("^[\\w.]*"))) {
        std::cout << nameSection << std::endl << parameter << " = ";
    }
    return result;
}

int FileProcessing::getInt(std::string nameSection, const std::string& parameter) const {
    nameSection.insert(0, "[");
    nameSection.insert(nameSection.length(), "]");
    std::string result;
    std::string mainValue = findValue(nameSection, parameter, result);
        if (!(std::regex_match(result, std::regex("^-[\\d]*"))
            || std::regex_match(result, std::regex("[\\d]*")))) {
            throw std::runtime_error("Value is not integer");
        } else{
            std::cout << nameSection << std::endl << parameter << " = ";
            return std::stoi(result);
        }
}

float FileProcessing::getFloat(std::string nameSection, const std::string& parameter) const {
    nameSection.insert(0, "[");
    nameSection.insert(nameSection.length(), "]");
    std::string result;
    std::string mainValue = findValue(nameSection, parameter, result);
    if(!(std::regex_match(result.begin(), result.end(), std::regex("^\\d*[.,]\\d+$")) ||
    std::regex_match(result.begin(), result.end(), std::regex("^-\\d*[.,]\\d+$")))) {
        throw std::runtime_error("Value is not float");
    } else {
        std::cout << nameSection << std::endl << parameter << " = ";
        return std::stof(result);
    }
}