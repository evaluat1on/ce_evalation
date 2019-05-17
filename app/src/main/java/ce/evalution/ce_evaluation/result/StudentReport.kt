package ce.evalution.ce_evaluation.result



class StudentReport {
    var stdCode:String
    var pfName:String
    var stdName:String
    var stdSurname:String
    var ss_grade:String

    constructor(stdCode:String,pfName:String,stdName:String,stdSurname:String,ss_grade:String){
        this.stdCode = stdCode
        this.pfName = pfName
        this.stdName = stdName
        this.stdSurname = stdSurname
        this.ss_grade = ss_grade
    }
}