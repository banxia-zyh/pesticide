/* eslint-disable */
export default {
    hasPermission (roleType, target, permission) {
        switch (roleType) {
            case 'ADMINISTRATOR':
                return true
            case 'PROJECT_MANAGER':
                switch (target) {
                    case 'PROJECT':
                        return false
                    case 'PERSONNEL':
                        return true
                    case 'DEFECT':
                        return true
                }
            case 'SOFTWARE_ENGINEER':
                switch (target) {
                    case 'PROJECT':
                        return false
                    case 'PERSONNEL':
                        return false
                    case 'DEFECT':
                        switch (permission) {
                            case 'ADD_DEFECT':
                                return false
                            case 'EDIT_STATE':
                                return true
                        }
                }
            case 'TEST_ENGINEER':
                switch (target) {
                    case 'PROJECT':
                        return false
                    case 'PERSONNEL':
                        return false
                    case 'DEFECT':
                        switch (permission) {
                            case 'ADD_DEFECT':
                                return true
                            case 'EDIT_STATE':
                                return true
                        }
                }
        }
        return false
    }
}
