package ce.evalution.ce_evaluation.result



class StudentReport {
    var stdCode:String
    var pfName:String
    var stdName:String
    var stdSurname:String
    var number_grade:String

    constructor(stdCode:String,pfName:String,stdName:String,stdSurname:String,number_grade:String){
        this.stdCode = stdCode
        this.pfName = pfName
        this.stdName = stdName
        this.stdSurname = stdSurname
        this.number_grade = number_grade
    }
}