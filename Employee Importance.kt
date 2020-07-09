/*
 *  // Definition for Employee.
 *  class Employee {
 *      var id:Int = 0
 *      var importance:Int = 0
 *      var subordinates:List<Int> = listOf()
 *  }
 */

class Solution {
    var ans = 0
    fun getImportance(employees: List<Employee?>, id: Int): Int {
        var subor: List<Int> = listOf()  
        for(e in employees){
            if(e!!.id == id){
                ans += e!!.importance
                for(s in e!!.subordinates){
                    getImportance(employees,s)
                }
            }
        }
        
        return ans
    }
}