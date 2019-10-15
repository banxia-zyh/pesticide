<template>
    <div class="col-lg-6">
        <div class="card">
            <div class="card-close">
                <div class="dropdown">
                    <button aria-expanded="false" aria-haspopup="true" class="dropdown-toggle" data-toggle="dropdown"
                            id="closeCard3" type="button"><i class="fa fa-ellipsis-v"></i></button>
                    <div aria-labelledby="closeCard3" class="dropdown-menu dropdown-menu-right has-shadow"><a
                        class="dropdown-item remove"
                        href="#">
                        <i class="fa fa-times"></i>Close</a><a class="dropdown-item edit" href="#"> <i
                        class="fa fa-gear"></i>Edit</a></div>
                </div>
            </div>
            <div class="card-header d-flex align-items-center">
                <h3 class="h4">项目人员</h3>
            </div>
            <div class="card-body">
                <div class="table-responsive">
                    <table class="table table-striped table-hover">
                        <thead>
                        <tr>
                            <th>序号</th>
                            <th>姓名</th>
                            <th>职位</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr :key="index" v-for="(personnel,index) in personnelList">
                            <th scope="row">{{index + 1}}</th>
                            <td>{{personnel.userId}}</td>
                            <td>{{getRoleTypeName(personnel.roleType)}}</td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
    import PersonnelService from '../../service/PersonnelService'
    import RoleTypeNameMap from '../../entity/RoleTypeNameMap'

    export default {
        name: 'Personnel',
        created () {
            // this.projectId = this.route.params.projectId
            this.projectId = 124
            this.getPersonnelList()
        },
        data () {
            return {
                map: RoleTypeNameMap,
                projectId: '',
                personnelList: []
            }
        },
        methods: {
            getPersonnelList () {
                PersonnelService.getPersonnelList(this.projectId, data => {
                    this.personnelList = data
                })
            },
            getRoleTypeName (roleType) {
                return this.map.get(roleType)
            }
        }
    }
</script>

<style scoped>

</style>
