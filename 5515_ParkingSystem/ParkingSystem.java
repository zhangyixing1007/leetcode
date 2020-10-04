/*
LeetCode Problem No.5515:   https://leetcode-cn.com/problems/design-parking-system/
Author:                     zhangyixing1007
Idea:                       simple syntax
Time:                       14 ms
Space:                      39.7 MB
*/

class ParkingSystem {

    int big, medium, small;
    public ParkingSystem(int big, int medium, int small) {
        this.big=big;
        this.medium=medium;
        this.small=small;
    }
    
    public boolean addCar(int carType) {
        if(carType==1) {
            big--;
            return big>=0;
        }else if(carType==2) {
            medium--;
            return medium>=0;
        }else {
            small--;
            return small>=0;
        }
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */
