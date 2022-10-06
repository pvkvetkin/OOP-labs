//
// Created by destr on 12.10.2020.
//

#include <iostream>
#include <queue>
#include <limits>
#include "Hypermarket.h"

int infinity = std::numeric_limits<int>::max();

int Hypermarket::getSizeOfShops() {
    if (mapOfShops.size() > infinity) {
        throw std::logic_error("Out of length 'int'");
    }
    return mapOfShops.size();
}

int Hypermarket::getSizeOfProducts() {
    if (mapOfProducts.size() > infinity) {
        throw std::logic_error("Out of length 'int'");
    }
    return mapOfProducts.size();
}

void Hypermarket::createShop(const std::string& name, const std::string& address) {
    incrSh += 1;
    mapOfShops[incrSh] = std::make_pair(name, address);
}

void Hypermarket::createProduct(const std::string& name) {
    incrPr += 1;
    mapOfProducts[incrPr] = std::make_pair(incrPr, name);
}

void Hypermarket::randomizer(Hypermarket& object) {
    for (int i = 0; i < object.getSizeOfShops(); ++i) {
        for (int j = 0; j < object.getSizeOfProducts(); ++j) {
            object.delivery(i, j, rand() % 5, rand() % 500 + 100);
        }
    }
}

void Hypermarket::delivery(int shopId, int productId, int count, int price) {
    if (count > infinity || price > infinity) {
        throw std::logic_error("Count or price out of length 'int'");
    } else if (count < 0 || price < 0) {
        throw std::logic_error("Value or count are negative");
    }
    if (count > 0) {
        mapOfShops[shopId].order(mapOfProducts[productId], count, price);
    }
}

void Hypermarket::delivery(int shopId, int productId, int count) {
    if (count > infinity) {
        throw std::logic_error("Count out of length 'int'");
    } else if (count < 0) {
        throw std::logic_error("Count or price are negative");
    }
    if (count > 0) {
        mapOfShops[shopId].order(mapOfProducts[productId], count);
    } else if (count < 0) {
        throw std::logic_error("Count is negative");
    }
}

int Hypermarket::findTheCheapestProduct (int id) {
    if (id > infinity) {
        throw std::logic_error("Id out of length 'int'");
    } else if (id < 0) {
        throw std::logic_error("Value of id is negative");
    }
    std::priority_queue<std::pair<int, std::pair<int, std::string>>> sortVector;
    sortVector.push(std::make_pair(infinity, std::make_pair(-1, " ")));
    for(auto &i : mapOfShops) {
        for(auto &j : i.second.getHyperMarket()) {
            if (j.first.getId() == id) {
                sortVector.push(std::make_pair(j.second.second, std::make_pair(i.first, j.first.getName())));
                sortVector.pop();
            }
        }
    }
//    std::cout << sortVector.top().second.second << " ";
    return sortVector.top().second.first;
}

void Hypermarket::WhatCanIBuy (int sum) {
    if (sum > infinity) {
        throw std::logic_error("Sum out of length 'int'");
    } else if (sum < 0) {
        throw std::logic_error("Value of sum is negative");
    }
    for(auto &i : mapOfShops) {
        std::cout << "In the '" << i.second.getName() << "' you can buy: " << std::endl;
        int iteration = 0;
        bool flag = false;
        for(auto &j : i.second.getHyperMarket()) {
            ++iteration;
            if (sum >= j.second.first * j.second.second && j.second.first != 0) {
                std::cout << j.second.first << " " << j.first.getName() << std::endl;
                flag = true;
            } else if (iteration == i.second.getHyperMarket().size() && !flag) {
                std::cout << "In this shop you can't buy anything" << std::endl;
                break;
            }
        }
    }
}

int Hypermarket::ForBuying (int id, const std::vector<std::pair<int, int>>& consignment) {
    if (id > infinity) {
        throw std::logic_error("Id out of length 'int'");
    } else if (id < 0) {
        throw std::logic_error("Value of id is negative");
    }
    int sum = 0;
    for(const auto & i : consignment) {
        bool flag = false;
        for (auto &j : mapOfShops[id].getHyperMarket()) {
            if (i.second == j.first.getId()) {
                flag = true;
                if (j.second.first >= i.first) {
                    sum += j.second.second * i.first;
                    j.second.first -= i.first;
                } else {
                    throw std::logic_error("Wrong count of requested products");
                }
                break;
            }
        }
        if (!flag) {
            throw std::logic_error("Invalid id");
        }
    }
    return sum;
}

int Hypermarket::TheCheapestShop (const std::vector<std::pair<int, int>>& consignment) {
    std::priority_queue<std::pair<int, std::pair<int, std::string>>> sortVector;
    sortVector.push(std::make_pair(infinity, std::make_pair(-10000, " ")));
    int sum;
    for(auto &i : mapOfShops) {
        sum = 0;
        for(auto &j : i.second.getHyperMarket()) {
            for(const auto & k : consignment) {
                if (j.first.getId() == k.first) {
                    if (j.second.first >= k.second) {
                        sum += k.second * j.second.second;
                    } else if (k.first < 0) {
                        throw std::logic_error("Invalid id");
                    } else {
                            std::cout << "Product out of stock";
                    }
                }
            }
        }
        sortVector.push(std::make_pair(sum, std::make_pair(i.first, i.second.getName())));
        sortVector.pop();
    }
    return sortVector.top().second.first;
}

void Hypermarket::printAll() {
    for(auto &i : mapOfShops) {
        std::cout << i.first << " " << i.second.getName() << " " << i.second.getAddress() << std::endl;
        for(auto &j : i.second.getHyperMarket()) {
            std::cout << j.first.getId() << " " << j.first.getName() << " " << j.second.first << " "
                      << j.second.second << std::endl;
        }
    }
}