//
export function getOperationMap() {
    var opereation_map = new Map([
        ["projectlists", true],
        ["fundlists", false],

        ["papers", true], 
        ["works", true], 
        ["patents", true], 
        ["scientifics", true], 

        ["teams", true], 

        ["project", true], 
        ["achievement", true], 
        ["personal", true], 
        ["college", true], 

        ["roles", true], 

        ["project_result", true], 
        ["paper_result", true], 
        ["work_result", true], 
        ["scientific_result", true], 
        ["patent_result", true], 

        ["project_check", true], 
        ["paper_check", true], 
        ["work_check", true], 
        ["scientific_check", true], 
        ["patent_check", true], 

        ["collegesdep", true], 
        ["researchers", true], 

        ["authoritylists", true],
        ["researcroleshers", true],

        ["loginlog", true], 
        ["systemlog", true], 
        ["operationlog", true],

        ["reports", false], 
        
        
    ]);

    return opereation_map;
}
