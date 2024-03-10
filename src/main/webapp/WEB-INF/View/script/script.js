const productForm=document.getElementById("productForm");
function validateForm() {
        var designation = document.getElementById("designation").value;
        var prix = document.getElementById("prix").value;
        var quantite = document.getElementById("quantite").value;

        if (designation.trim() === '' || prix.trim() === '' || quantite.trim() === '') {
            alert("Please fill out all fields.");
            return false;
        }

        if (isNaN(prix) || isNaN(quantite)) {
            alert("Prix and Quantite must be numbers.");
            return false;
        }

        if (/^[a-zA-Z0-9- ]*$/.test(designation) == false) {
            alert("Designation should not contain special characters.");
            return false;
        }

        return true;
    }
 
 
productForm.addEventListener("submit",(e)=>{
	
	if(!validateForm()){
		e.preventDefault()
	}
	
})  
    
    
    
    
    
    
    
    
    
    
    
    