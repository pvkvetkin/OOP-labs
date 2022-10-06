#include <iostream>
#include "FileProcessing.h"

int main() {
    std::string nameOfFile = "test.ini";
    FileProcessing file(nameOfFile);
    std::string buffer, section, parameter, type;
    try {
        while (true) {
            std::cout << std::endl << "Type SECTION PARAMETER TYPE OF VALUE (integer/float/string)" << std::endl
                      << "type 'exit' to exit" << std::endl;
            std::cin >> buffer;
            if (buffer == "exit") {
                return 0;
            }
            section = buffer;
            std::cin >> parameter >> type;
            if (type == "integer"){
                std::cout << file.getInt(section, parameter) << std::endl;
            }else if (type == "float") {
                std::cout << file.getFloat(section, parameter) << std::endl;
            } else if (type == "string"){
                std::cout << file.getString(section, parameter) << std::endl;
            } else {
                std::cout << "Unknown type of value. Try again!" << std::endl;
            }
        }
    } catch (const std::exception& error) {
        std::cerr << error.what() << std::endl;
        return -1;
    }
}