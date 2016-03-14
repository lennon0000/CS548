(: XQuery main module :)

import schema namespace p = "http://www.example.org/schemas/clinic/patient" at "Patient.xsd";
import schema namespace prov = "http://www.example.org/schemas/clinic/provider" at "Provider.xsd";
import schema namespace c = "http://www.example.org/schemas/clinic" at "Clinic.xsd";

import module namespace assignment3 = "http://www.example.com/xquery/clinic/Assignment3" at "Assignment3.xq";

declare namespace trmtInfo = "http://www.example.org/schemas/clinic/patient/treatmentInfo";
declare namespace res = "http://www.example.org/schemas/clinic/patient/drug-treatments";
declare namespace ps = "http://www.example.org/schemas/clinic/patients";


let $clinic := doc("ClinicData.xml")/c:Clinic


return assignment3:getPatientTreatments($clinic)
return assignment3:getPatientDrugs($clinic)
return assignment3:getTreatmentInfo($clinic)
return assignment3:getProviderInfo($clinic)
return assignment3:getDrugInfo($clinic)