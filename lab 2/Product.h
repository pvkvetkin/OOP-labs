//
// Created by destr on 12.10.2020.
//

#ifndef OOP_LABORATORY_WORK_2_PRODUCT_H
#define OOP_LABORATORY_WORK_2_PRODUCT_H


#include <string>

class Product {
public:
    Product() = default;

    Product(const std::pair<int, std::string>&);

    int getId() const;

    std::string getName() const;

    bool operator<(const Product&) const;

private:
    int id;

    std::string name;
};


#endif //OOP_LABORATORY_WORK_2_PRODUCT_H