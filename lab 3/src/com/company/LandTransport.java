package com.company;

public abstract class LandTransport extends GeneralTransport{
    LandTransport(double speed_, String name_, double restInterval_) {
        super(speed_, name_);
        if (restInterval_ < 0.0d) {
            throw new RuntimeException("Value of rest interval is wrong");
        }
        restInterval = restInterval_;
    }
}