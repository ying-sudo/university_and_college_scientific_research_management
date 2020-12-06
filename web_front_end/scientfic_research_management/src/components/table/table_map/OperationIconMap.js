export function getTableIconMap() {
    var icon_map = new Map([
        ["authoritylists", "AuthorityTableIcon"], 
        ["projectlists", "ProjectTableIcon"], 
        ["fundlists","FundsTableIcon"],
        ["teams","TeamTableIcon"],
        ["papers","PaperTableIcon"],
        ["works","WorkTableIcon"],
        ["patents","PatentTableIcon"],
        
        
    ]);

    return icon_map;
}