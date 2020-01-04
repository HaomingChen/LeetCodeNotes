package crackingleetcode;

/**
 * 假设有3栋楼，每栋楼都有对应的高度，假设是(10,15,12)，我们有升序排列的包裹，代号表示为（9,14,25,36），
 * 要输出包裹被deliver到第几栋大楼的第几层，这个意思就是假设包裹是9，就输出第一栋的第9层，19这个样子。14就是第二栋楼
 * 的第四层，24。以此类推
 *
 * @author Haoming Chen
 * Created on 2020/1/4
 */
public class PackageDelivery_Microsoft01 {

    int[] building;
    int[] pkg;

    public PackageDelivery_Microsoft01(int[] building, int[] pkg) {
        this.building = new int[building.length];
        this.pkg = new int[pkg.length];
        for (int i = 0; i < building.length; i++) {
            this.building[i] = building[i];
        }
        for (int j = 0; j < pkg.length; j++) {
            this.pkg[j] = pkg[j];
        }
    }

    public void deliveryPackage() {
        int currentBuilding = 0;
        int currentLevel = 0;
        boolean[] visited = new boolean[building.length];
        for (int i = 0; i < pkg.length; i++) {
            int pkgNum = pkg[i] - currentLevel;
            for(; currentBuilding < building.length; currentBuilding++){
                if(pkgNum <= building[currentBuilding]){
                    System.out.println("current building: " + (currentBuilding + 1) + " level: " + pkgNum);
                    if(currentBuilding > 0 && !visited[currentBuilding]) {
                        currentLevel = currentLevel + building[currentBuilding - 1];
                        visited[currentBuilding] = true;
                    }
                    break;
                }else{
                    pkgNum = pkgNum - building[currentBuilding];
                }
            }
        }
    }

    public static void main(String[] args) {
        PackageDelivery_Microsoft01 packageDelivery_microsoft01 =
                new PackageDelivery_Microsoft01(new int[]{10,15,12}, new int[]{9,14,25,36});
        packageDelivery_microsoft01.deliveryPackage();
    }

}
