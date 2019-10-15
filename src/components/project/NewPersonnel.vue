<template>
    <div class="col-lg-6">
        <div class="card">
            <div class="card-header d-flex align-items-center">
                <h3 class="h4">{{title + '人员'}}</h3>
            </div>
            <div class="card-body">
                <form class="form-horizontal" style="text-align: center">
                    <div class="form-group row">
                        <label class="col-sm-3 form-control-label" style="margin: auto">用户名</label>
                        <div class="col-sm-9">
                            <input class="form-control form-control-success" type="text" v-model="personnel.userId">
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-3 form-control-label" style="margin: auto">职位</label>
                        <div class="col-sm-9">
                            <select class="form-control form-control-warning" v-model="personnel.roleType">
                                <option disabled value="">请选择</option>
                                <option :key="value" :value="value" v-for="(value) in roleTypeNameMap.keys()">
                                    {{roleTypeNameMap.get(value)}}
                                </option>
                                <!--<option value="w">软件工程师</option>-->
                                <!--<option valu/e="w">测试工程师</option>-->
                            </select>
                        </div>
                    </div>
                    <div class="form-group row">
                        <div class="col-sm-12">
                            <button @click="addPersonnel" class="btn btn-primary" style="width: 30%">{{title}}</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</template>

<script>

    import RoleTypeNameMap from '../../entity/RoleTypeNameMap'
    import PersonnelService from '../../service/PersonnelService'

    export default {
        name: 'NewPersonnel',
        created () {
            // let params = this.route.params
            // this.title = params.title
            this.personnel.projectId = 124
        },
        data () {
            return {
                title: '',
                roleTypeNameMap: RoleTypeNameMap,
                personnel: {
                    userId: '',
                    projectId: '',
                    roleType: ''
                }
            }
        },
        methods: {
            addPersonnel () {
                PersonnelService.addPersonnel(this.personnel, () => {
                    alert('添加成功！')
                })
            }
        }
    }
</script>

<style scoped>

</style>
