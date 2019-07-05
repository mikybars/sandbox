package com.inditex.rrhh.icmclcwb.api.app.trabajo.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.util.CollectionUtils;

import com.inditex.rrhh.icmclcwb.api.app.TipoAmbitoEnum;
import com.inditex.rrhh.icmclcwb.api.app.run.trabajo.dto.RunTrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;

public class TrabajoConstraintValidator implements ConstraintValidator<TrabajoValidator, Object> {

    @Override
    public boolean isValid(Object object, ConstraintValidatorContext context) {
       
        boolean isValid = true;
       
        if(object instanceof TrabajoDto) {
            TrabajoDto trabajo = ((TrabajoDto) object);
            isValid = validate(trabajo, context, isValid);
        }
        
        if (object instanceof RunTrabajoDto) {
            TrabajoDto trabajo = ((RunTrabajoDto) object).getTrabajo();
            isValid = validate(trabajo, context, isValid);
        }

        if(!isValid) {
            context.disableDefaultConstraintViolation();
        }
        
        return isValid;
    }

    private boolean validate(TrabajoDto trabajo, ConstraintValidatorContext context, boolean isValid) {
        if(TipoAmbitoEnum.SOCIEDAD.getId().equals(trabajo.getTipoAmbito().getId())) {
            if (!CollectionUtils.isEmpty(trabajo.getOrigen())) {
                context.buildConstraintViolationWithTemplate("Ejecucion por sociedad con origen en la entrada").addConstraintViolation();
                isValid = false;
            }
        }
        
        if (TipoAmbitoEnum.ORIGEN.getId().equals(trabajo.getTipoAmbito().getId())) {
            if (CollectionUtils.isEmpty(trabajo.getOrigen())) {
                context.buildConstraintViolationWithTemplate("Ejecucion por origen sin origen en la entrada").addConstraintViolation();
                isValid = false;  
            }
            
            if (!CollectionUtils.isEmpty(trabajo.getEmpresa())) {
                context.buildConstraintViolationWithTemplate("Ejecucion por origen con empresas en la entrada").addConstraintViolation();
                isValid = false;
            }                
        }
        
        if (TipoAmbitoEnum.EMPRESA.getId().equals(trabajo.getTipoAmbito().getId())) {
            if (CollectionUtils.isEmpty(trabajo.getOrigen())) {
                context.buildConstraintViolationWithTemplate("Ejecucion por empresa sin origen en la entrada").addConstraintViolation();
                isValid = false;  
            }
            
            if (CollectionUtils.isEmpty(trabajo.getEmpresa())) {
                context.buildConstraintViolationWithTemplate("Ejecucion por empresa sin empresas en la entrada").addConstraintViolation();
                isValid = false;
            }          
        }
        
        if (TipoAmbitoEnum.LOCALIZACION.getId().equals(trabajo.getTipoAmbito().getId())) {
            if (CollectionUtils.isEmpty(trabajo.getOrigen())) {
                context.buildConstraintViolationWithTemplate("Ejecucion por localizacion sin origen en la entrada").addConstraintViolation();
                isValid = false;  
            }
            
            if (CollectionUtils.isEmpty(trabajo.getEmpresa())) {
                context.buildConstraintViolationWithTemplate("Ejecucion por localizacion sin empresas en la entrada").addConstraintViolation();
                isValid = false;
            }     
            
            if (CollectionUtils.isEmpty(trabajo.getLocalizacion())) {
                context.buildConstraintViolationWithTemplate("Ejecucion por localizacion sin localizaciones en la entrada").addConstraintViolation();
                isValid = false;
            }     
            
            if (!CollectionUtils.isEmpty(trabajo.getPersona())) {
                context.buildConstraintViolationWithTemplate("Ejecucion por localizacion con personas en la entrada").addConstraintViolation();
                isValid = false;
            }   
        }
            
        if (TipoAmbitoEnum.PERSONA.getId().equals(trabajo.getTipoAmbito().getId())) {
            if (CollectionUtils.isEmpty(trabajo.getOrigen())) {
                context.buildConstraintViolationWithTemplate("Ejecucion por persona sin origen en la entrada").addConstraintViolation();
                isValid = false;  
            }
            
            if (CollectionUtils.isEmpty(trabajo.getEmpresa())) {
                context.buildConstraintViolationWithTemplate("Ejecucion por persona sin empresas en la entrada").addConstraintViolation();
                isValid = false;
            }
            
            if (CollectionUtils.isEmpty(trabajo.getPersona())) {
                context.buildConstraintViolationWithTemplate("Ejecucion por persona sin personas en la entrada").addConstraintViolation();
                isValid = false;
            }   
            
            if (!CollectionUtils.isEmpty(trabajo.getLocalizacion())) {
                context.buildConstraintViolationWithTemplate("Ejecucion por persona con localizaciones en la entrada").addConstraintViolation();
                isValid = false;
            }  
        }
        return isValid;
    }

}
