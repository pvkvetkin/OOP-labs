//
// Created by destr on 12.10.2020.
//

#ifndef OOP_LABORATORY_WORK_2_HYPERMARKET_H
#define OOP_LABORATORY_WORK_2_HYPERMARKET_H


#include <map>
#include "Shop.h"
#include "Product.h"

class Hypermarket {
public:
    Hypermarket() = default;

    int getSizeOfProducts();

    int getSizeOfShops();

    void createProduct(const std::string&);

    void createShop(const std::string&, const std::string&);

    void delivery(int, int, int);

    void delivery(int, int, int, int);

    static void randomizer(Hypermarket&);

    int findTheCheapestProduct(int);

    void WhatCanIBuy(int);

    int ForBuying(int, const std::vector<std::pair<int, int>>&);

    int TheCheapestShop(const std::vector<std::pair<int, int>>&);

    void printAll();
private:
    int incrSh = -1;

    int incrPr = -1;

    std::map<int, Shop> mapOfShops;

    std::map<int, Product> mapOfProducts;
};


#endif //OOP_LABORATORY_WORK_2_HYPERMARKET_H