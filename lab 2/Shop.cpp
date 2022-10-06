//
// Created by destr on 12.10.2020.
//

#include "Shop.h"

Shop::Shop(std::string name_, std::string address_) :
        name(std::move(name_)),
        address(std::move(address_))
{}

Shop::Shop(const std::pair <std::string, std::string>& nameAddress) {
    name = nameAddress.first;
    address = nameAddress.second;
}

std::string Shop::getName() const {
    return name;
}

std::string Shop::getAddress() const {
    return address;
}

std::map<Product, std::pair<int, int>> Shop::getHyperMarket () {
    return hyperMarket;
}

void Shop::order(const Product &objItem, int count, int price) {
//    std::pair<int, int> somePair (count, price);
//    hyperMarket.insert(std::pair<Product, std::pair<int, int>> (objItem, std::pair<int, int> (somePair)));
//    hyperMarket.insert(std::make_pair(objItem, somePair));
    hyperMarket[objItem].first = count;
    hyperMarket[objItem].second = price;
}

void Shop::order(const Product &objItem, int count) {
//    std::pair<int, int> somePair (count, price);
//    hyperMarket.insert(std::pair<Product, std::pair<int, int>> (objItem, std::pair<int, int> (somePair)));
//    hyperMarket.insert(std::make_pair(objItem, somePair));
    hyperMarket[objItem].first += count;
}