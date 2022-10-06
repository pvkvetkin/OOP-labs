#include <iostream>
#include <vector>
#include "Hypermarket.h"

int main() {
    try {
        Hypermarket chainOfHypermarket;
        chainOfHypermarket.createProduct("A");
        chainOfHypermarket.createProduct("B");
        chainOfHypermarket.createProduct("C");
        chainOfHypermarket.createProduct("D");
        chainOfHypermarket.createProduct("E");
        chainOfHypermarket.createProduct("F");
        chainOfHypermarket.createProduct("G");
        chainOfHypermarket.createProduct("J");
        chainOfHypermarket.createProduct("Y");
        chainOfHypermarket.createProduct("H");
        chainOfHypermarket.createShop("Letters", "Ulica");
        chainOfHypermarket.createShop("Numbers", "Prospect");
        chainOfHypermarket.createShop("Words", "Naberezhnaya");
        Hypermarket::randomizer(chainOfHypermarket);
        chainOfHypermarket.delivery(0, 0, 5);
        chainOfHypermarket.printAll() ;
        std::cout << "The cheapest product in " << chainOfHypermarket.findTheCheapestProduct(7) << std::endl;
        chainOfHypermarket.WhatCanIBuy(1500);
        std::vector<std::pair<int, int>> forBuy;
        forBuy.emplace_back(4, 5);
        std::cout << "The total sum of the consignment: " << chainOfHypermarket.ForBuying(2, forBuy) << std::endl;
        std::vector<std::pair<int, int>> forBuySum;
        forBuySum.emplace_back(3, 1);
        std::cout << "The cheapest shop is " << chainOfHypermarket.TheCheapestShop(forBuySum);
    } catch (std::exception& error) {
        std::cerr << error.what() << std::endl;
        return -1;
    }
    return 0;
}