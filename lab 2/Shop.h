//
// Created by destr on 12.10.2020.
//

#ifndef OOP_LABORATORY_WORK_2_SHOP_H
#define OOP_LABORATORY_WORK_2_SHOP_H

#include <string>
#include <map>
#include <unordered_map>
#include <iostream>
#include "Product.h"


class Shop {
public:
    Shop() = default;

    Shop(std::string, std::string);

    Shop(const std::pair <std::string, std::string>&);

    std::string getName() const;

    std::string getAddress() const;

    std::map<Product, std::pair<int, int>> getHyperMarket();

    void order(const Product&, int, int);

    void order(const Product&, int);
private:
    std::string name;

    std::string address;

    std::map<Product, std::pair<int, int>> hyperMarket;
};



#endif //OOP_LABORATORY_WORK_2_SHOP_H