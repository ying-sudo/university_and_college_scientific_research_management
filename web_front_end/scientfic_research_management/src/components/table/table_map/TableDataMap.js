export function getTableDataMap() {
    var table_data_map = new Map([
        ["projectlists", "mangerSys/projects/users"], 
        ["fundlists", "mangerSys/funds/projects"], 

        ["papers", "mangerSys/achievements/paper/users"], 
        ["works", "mangerSys/achievements/work/users"],  
        ["scientifics", "mangerSys/achievements/scientific/users"], 
        ["patents", "mangerSys/achievements/patent/users"],

        ["teams", "mangerSys/teams/users"], 
        
        ["project_result", "mangerSys/assess/projects/user"], 
        ["paper_result", "mangerSys/assess/papers/user"], 
        ["scientific_result", "mangerSys/assess/scientifics/user"], 
        ["work_result", "mangerSys/assess/works/user"], 
        ["patent_result", "mangerSys/assess/patents/user"],   

        ["authoritylists", "/api/table_data"], 


        
    ]);

    return table_data_map;
}