package guet.hj.travel.service;

import guet.hj.travel.entity.FrontUser;

public interface FrontUserService {
    FrontUser getFrontUser(String userPhone);

    void saveFrontUser(FrontUser frontUser);
}
