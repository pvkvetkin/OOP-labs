//
// Created by destr on 12.10.2020.
//

#include "Product.h"

int Product::getId() const {
    return id;
}

std::string Product::getName() const {
    return name;
};

bool Product::operator<(const Product& object) const {
    return id < object.id;
}

Product::Product(const std::pair<int, std::string>& idName) {
    id = idName.first;
    name = idName.second;
}
