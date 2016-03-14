module namespace assignment3 = 'http://www.example.com/xquery/clinic/Assignment3';
import schema namespace p = "http://www.example.org/schemas/clinic/patient" at "Patient.xsd";
import schema namespace c = "http://www.example.org/schemas/clinic" at "Clinic.xsd";
import schema namespace t = "http://www.example.org/schemas/clinic/treatment" at "Treatment.xsd";
import schema namespace pr = "http://www.example.org/schemas/clinic/provider" at "Provider.xsd";
     
        
declare function assignment3:getPatientTreatments ($klinic as element (c:Clinic))
        as element (*)* {
        element assignment3:treatments{
         $klinic/p:Patient[p:name="Wangwu"]/p:treatments/p:treatment 
        }
        };

declare function assignment3:getPatientDrugs ($klinic as element (c:Clinic))
        as element (*)* {
            element assignment3:Drugs{
                for $drugTs in $klinic/p:Patient[p:name="Wangwu"]/p:treatments/p:treatment/t:drug-treatment
                    return element assignment3:Drug{
                      $drugTs/../t:diagnose | $drugTs
                    }
            }
    
      };    
        
declare function assignment3:getTreatmentInfo($klinic as element (c:Clinic))
        as element (*)* {
        
            element assignment3:Treatments{
        
                for $trmts in $klinic//p:treatment
                    return element assignment3:Treatment {
                
                        element p:patient-id{$trmts/../../p:patient-id/text() } | $trmts
                        }
             }
        
        };  
           
declare function assignment3:getProviderInfo($klinic as element (c:Clinic))
        as element (*)* {
        
            
            element assignment3:ProviderInfo{
                for $provs in $klinic/pr:Provider
                    return element pr:Provider-Patients{$provs, element p:Patients{
                        
                       for $trmt in $klinic//p:treatment
                       where $trmt/t:provider-id = $provs/pr:provider-id
                       return $trmt | $trmt/../../p:name
                        }
                    }
            }
        
        };      
declare function assignment3:getDrugInfo($klinic as element (c:Clinic))
        as element (*)* {
        let $pats := $klinic/p:Patient  
        let $provs := $klinic/p:Provider

        return     
        element assignment3:Drugs{
            for $drugs in $klinic//t:drug-treatment/t:name
                return element assignment3:Drugs{
                    element t:DrugInfo{$drugs/text()},element p:Patients{
                    
                    for $patDrugs in $pats//t:drug-treatment/t:name
                    where $drugs = $patDrugs
                    let $patDiag := $patDrugs/../../t:diagnose
                    let $pat := $patDrugs/../../../..
                    let $proId := $patDrugs/../../t:provider-id
                    return element p:Patient{
                        element p:PatientId{$pat/p:patient-id/text()},element p:PatientName{$pat/p:name/text()}, element p:diagnose{$patDiag/text()},element pr:Provider{
                            for $provs in $klinic/pr:Provider
                            where $provs/pr:provider-id = $proId
                            return element pr:ProviderId{$provs/pr:provider-id/text()} | element pr:ProviderName{$provs/pr:name/text()}
                            }
                           }
                    }
                }
        }      
     
};     
   
       
      
        
        
 
  
