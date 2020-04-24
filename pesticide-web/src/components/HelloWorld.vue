<template>
    <div>
        <el-button @click="outerVisible = true" type="text">点击打开外层 Dialog</el-button>

        <el-dialog :visible.sync="outerVisible" title="外层 Dialog">
            <el-dialog
                :visible.sync="innerVisible"
                append-to-body
                title="内层 Dialog"
                width="30%">
            </el-dialog>
            <div class="dialog-footer" slot="footer">
                <el-button @click="outerVisible = false">取 消</el-button>
                <el-button @click="innerVisible = true" type="primary">打开内层 Dialog</el-button>
            </div>
        </el-dialog>
    </div>
</template>

<script>
    export default {
        data () {
            return {
                outerVisible: false,
                innerVisible: false
            }
        }
    }
</script>
