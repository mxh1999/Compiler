package beta1.Trans;

public class preFuncTranslator {
    public static void addpreFunc(StringBuilder str) {
        str.append("SECTION .text\n" +
                "\n" +
                "_array_size_func:\n" +
                "        mov     rax, [rdi]\n" +
                "        ret");
        str.append("\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "default rel\n" +
                "\n" +
                "global print_func\n" +
                "global println_func\n" +
                "global getString_func\n" +
                "global getInt_func\n" +
                "global toString_func\n" +
                "global _string_length_func\n" +
                "global _string_substring_func\n" +
                "global _string_parseInt_func\n" +
                "global _string_ord_func\n" +
                "global _string_add_func\n" +
                "global _string_less_func\n" +
                "global _string_lessequal_func\n" +
                "global _string_great_func\n" +
                "global _string_greaterequal_func\n" +
                "global _string_equal_func\n" +
                "global _string_notequal_func\n" +
                "\n" +
                "extern strcmp\n" +
                "extern strcpy\n" +
                "extern strlen\n" +
                "extern malloc\n" +
                "extern __stack_chk_fail\n" +
                "extern __isoc99_scanf\n" +
                "extern puts\n" +
                "extern printf\n" +
                "extern _GLOBAL_OFFSET_TABLE_\n" +
                "\n" +
                "\n" +
                "SECTION .text   \n" +
                "\n" +
                "print_func:\n" +
                "        push    rbp\n" +
                "        mov     rbp, rsp\n" +
                "        sub     rsp, 16\n" +
                "        mov     qword [rbp-8H], rdi\n" +
                "        mov     rax, qword [rbp-8H]\n" +
                "        mov     rsi, rax\n" +
                "        lea     rdi, [rel L_017]\n" +
                "        mov     eax, 0\n" +
                "        call    printf\n" +
                "        nop\n" +
                "        leave\n" +
                "        ret\n" +
                "\n" +
                "\n" +
                "println_func:\n" +
                "        push    rbp\n" +
                "        mov     rbp, rsp\n" +
                "        sub     rsp, 16\n" +
                "        mov     qword [rbp-8H], rdi\n" +
                "        mov     rax, qword [rbp-8H]\n" +
                "        mov     rdi, rax\n" +
                "        call    puts\n" +
                "        nop\n" +
                "        leave\n" +
                "        ret\n" +
                "\n" +
                "\n" +
                "getString_func:\n" +
                "        push    rbp\n" +
                "        mov     rbp, rsp\n" +
                "        sub     rsp, 16\n" +
                "        mov     rax, qword [rbp-8H]\n" +
                "        mov     rsi, rax\n" +
                "        lea     rdi, [rel L_017]\n" +
                "        mov     eax, 0\n" +
                "        call    __isoc99_scanf\n" +
                "        mov     rax, qword [rbp-8H]\n" +
                "        leave\n" +
                "        ret\n" +
                "\n" +
                "\n" +
                "getInt_func:\n" +
                "        push    rbp\n" +
                "        mov     rbp, rsp\n" +
                "        sub     rsp, 16\n" +
                "\n" +
                "\n" +
                "        mov     rax, qword [fs:abs 28H]\n" +
                "        mov     qword [rbp-8H], rax\n" +
                "        xor     eax, eax\n" +
                "        lea     rax, [rbp-10H]\n" +
                "        mov     rsi, rax\n" +
                "        lea     rdi, [rel L_018]\n" +
                "        mov     eax, 0\n" +
                "        call    __isoc99_scanf\n" +
                "        mov     rax, qword [rbp-10H]\n" +
                "        mov     rdx, qword [rbp-8H]\n" +
                "\n" +
                "\n" +
                "        xor     rdx, qword [fs:abs 28H]\n" +
                "        jz      L_001\n" +
                "        call    __stack_chk_fail\n" +
                "L_001:  leave\n" +
                "        ret\n" +
                "\n" +
                "\n" +
                "toString_func:\n" +
                "        push    rbp\n" +
                "        mov     rbp, rsp\n" +
                "        sub     rsp, 48\n" +
                "        mov     qword [rbp-28H], rdi\n" +
                "        mov     rax, qword [rbp-28H]\n" +
                "        mov     qword [rbp-20H], rax\n" +
                "        mov     qword [rbp-18H], 0\n" +
                "        cmp     qword [rbp-20H], 0\n" +
                "        jns     L_002\n" +
                "        add     qword [rbp-18H], 1\n" +
                "        neg     qword [rbp-20H]\n" +
                "L_002:  cmp     qword [rbp-20H], 0\n" +
                "        jnz     L_004\n" +
                "        add     qword [rbp-18H], 1\n" +
                "        jmp     L_004\n" +
                "\n" +
                "L_003:  add     qword [rbp-18H], 1\n" +
                "        mov     rcx, qword [rbp-20H]\n" +
                "        mov     rdx, qword 6666666666666667H\n" +
                "        mov     rax, rcx\n" +
                "        imul    rdx\n" +
                "        sar     rdx, 2\n" +
                "        mov     rax, rcx\n" +
                "        sar     rax, 63\n" +
                "        sub     rdx, rax\n" +
                "        mov     rax, rdx\n" +
                "        mov     qword [rbp-20H], rax\n" +
                "L_004:  cmp     qword [rbp-20H], 0\n" +
                "        jnz     L_003\n" +
                "        mov     rax, qword [rbp-18H]\n" +
                "        add     rax, 1\n" +
                "        mov     rdi, rax\n" +
                "        call    malloc\n" +
                "        mov     qword [rbp-8H], rax\n" +
                "        mov     rdx, qword [rbp-18H]\n" +
                "        mov     rax, qword [rbp-8H]\n" +
                "        add     rax, rdx\n" +
                "        mov     byte [rax], 0\n" +
                "        cmp     qword [rbp-28H], 0\n" +
                "        jns     L_005\n" +
                "        mov     rax, qword [rbp-8H]\n" +
                "        mov     byte [rax], 45\n" +
                "        neg     qword [rbp-28H]\n" +
                "L_005:  cmp     qword [rbp-28H], 0\n" +
                "        jnz     L_006\n" +
                "        mov     rax, qword [rbp-8H]\n" +
                "        mov     byte [rax], 48\n" +
                "        mov     rax, qword [rbp-8H]\n" +
                "        jmp     L_011\n" +
                "\n" +
                "L_006:  mov     rax, qword [rbp-18H]\n" +
                "        sub     rax, 1\n" +
                "        mov     qword [rbp-10H], rax\n" +
                "        jmp     L_008\n" +
                "\n" +
                "L_007:  mov     rcx, qword [rbp-28H]\n" +
                "        mov     rdx, qword 6666666666666667H\n" +
                "        mov     rax, rcx\n" +
                "        imul    rdx\n" +
                "        sar     rdx, 2\n" +
                "        mov     rax, rcx\n" +
                "        sar     rax, 63\n" +
                "        sub     rdx, rax\n" +
                "        mov     rax, rdx\n" +
                "        shl     rax, 2\n" +
                "        add     rax, rdx\n" +
                "        add     rax, rax\n" +
                "        sub     rcx, rax\n" +
                "        mov     rdx, rcx\n" +
                "        mov     eax, edx\n" +
                "        lea     ecx, [rax+30H]\n" +
                "        mov     rdx, qword [rbp-10H]\n" +
                "        mov     rax, qword [rbp-8H]\n" +
                "        add     rax, rdx\n" +
                "        mov     edx, ecx\n" +
                "        mov     byte [rax], dl\n" +
                "        mov     rcx, qword [rbp-28H]\n" +
                "        mov     rdx, qword 6666666666666667H\n" +
                "        mov     rax, rcx\n" +
                "        imul    rdx\n" +
                "        sar     rdx, 2\n" +
                "        mov     rax, rcx\n" +
                "        sar     rax, 63\n" +
                "        sub     rdx, rax\n" +
                "        mov     rax, rdx\n" +
                "        mov     qword [rbp-28H], rax\n" +
                "        cmp     qword [rbp-28H], 0\n" +
                "        jz      L_009\n" +
                "        sub     qword [rbp-10H], 1\n" +
                "L_008:  cmp     qword [rbp-10H], 0\n" +
                "        jns     L_007\n" +
                "        jmp     L_010\n" +
                "\n" +
                "L_009:  nop\n" +
                "L_010:  mov     rax, qword [rbp-8H]\n" +
                "L_011:  leave\n" +
                "        ret\n" +
                "\n" +
                "\n" +
                "_string_length_func:\n" +
                "        push    rbp\n" +
                "        mov     rbp, rsp\n" +
                "        sub     rsp, 16\n" +
                "        mov     qword [rbp-8H], rdi\n" +
                "        mov     rax, qword [rbp-8H]\n" +
                "        mov     rdi, rax\n" +
                "        call    strlen\n" +
                "        leave\n" +
                "        ret\n" +
                "\n" +
                "\n" +
                "_string_substring_func:\n" +
                "        push    rbp\n" +
                "        mov     rbp, rsp\n" +
                "        sub     rsp, 64\n" +
                "        mov     qword [rbp-28H], rdi\n" +
                "        mov     qword [rbp-30H], rsi\n" +
                "        mov     qword [rbp-38H], rdx\n" +
                "        mov     rax, qword [rbp-38H]\n" +
                "        sub     rax, qword [rbp-30H]\n" +
                "        add     rax, 2\n" +
                "        mov     qword [rbp-10H], rax\n" +
                "        mov     rax, qword [rbp-10H]\n" +
                "        mov     rdi, rax\n" +
                "        call    malloc\n" +
                "        mov     qword [rbp-8H], rax\n" +
                "        mov     rax, qword [rbp-10H]\n" +
                "        lea     rdx, [rax-1H]\n" +
                "        mov     rax, qword [rbp-8H]\n" +
                "        add     rax, rdx\n" +
                "        mov     byte [rax], 0\n" +
                "        mov     rax, qword [rbp-30H]\n" +
                "        mov     qword [rbp-18H], rax\n" +
                "        jmp     L_013\n" +
                "\n" +
                "L_012:  mov     rdx, qword [rbp-18H]\n" +
                "        mov     rax, qword [rbp-28H]\n" +
                "        lea     rcx, [rdx+rax]\n" +
                "        mov     rax, qword [rbp-18H]\n" +
                "        sub     rax, qword [rbp-30H]\n" +
                "        mov     rdx, rax\n" +
                "        mov     rax, qword [rbp-8H]\n" +
                "        add     rdx, rax\n" +
                "        movzx   eax, byte [rcx]\n" +
                "        mov     byte [rdx], al\n" +
                "        add     qword [rbp-18H], 1\n" +
                "L_013:  mov     rax, qword [rbp-18H]\n" +
                "        cmp     rax, qword [rbp-38H]\n" +
                "        jle     L_012\n" +
                "        mov     rax, qword [rbp-8H]\n" +
                "        leave\n" +
                "        ret\n" +
                "\n" +
                "\n" +
                "_string_parseInt_func:\n" +
                "        push    rbp\n" +
                "        mov     rbp, rsp\n" +
                "        mov     qword [rbp-18H], rdi\n" +
                "        mov     qword [rbp-10H], 0\n" +
                "        mov     rax, qword [rbp-18H]\n" +
                "        mov     qword [rbp-8H], rax\n" +
                "        jmp     L_015\n" +
                "\n" +
                "L_014:  mov     rdx, qword [rbp-10H]\n" +
                "        mov     rax, rdx\n" +
                "        shl     rax, 2\n" +
                "        add     rax, rdx\n" +
                "        add     rax, rax\n" +
                "        mov     rdx, rax\n" +
                "        mov     rax, qword [rbp-8H]\n" +
                "        movzx   eax, byte [rax]\n" +
                "        movsx   rax, al\n" +
                "        add     rax, rdx\n" +
                "        sub     rax, 48\n" +
                "        mov     qword [rbp-10H], rax\n" +
                "        add     qword [rbp-8H], 1\n" +
                "L_015:  mov     rax, qword [rbp-8H]\n" +
                "        movzx   eax, byte [rax]\n" +
                "        cmp     al, 57\n" +
                "        jg      L_016\n" +
                "        mov     rax, qword [rbp-8H]\n" +
                "        movzx   eax, byte [rax]\n" +
                "        cmp     al, 47\n" +
                "        jg      L_014\n" +
                "L_016:  mov     rax, qword [rbp-10H]\n" +
                "        pop     rbp\n" +
                "        ret\n" +
                "\n" +
                "\n" +
                "_string_ord_func:\n" +
                "        push    rbp\n" +
                "        mov     rbp, rsp\n" +
                "        mov     qword [rbp-8H], rdi\n" +
                "        mov     qword [rbp-10H], rsi\n" +
                "        mov     rdx, qword [rbp-10H]\n" +
                "        mov     rax, qword [rbp-8H]\n" +
                "        add     rax, rdx\n" +
                "        movzx   eax, byte [rax]\n" +
                "        movsx   rax, al\n" +
                "        pop     rbp\n" +
                "        ret\n" +
                "\n" +
                "\n" +
                "_string_add_func:\n" +
                "        push    rbp\n" +
                "        mov     rbp, rsp\n" +
                "        sub     rsp, 48\n" +
                "        mov     qword [rbp-28H], rdi\n" +
                "        mov     qword [rbp-30H], rsi\n" +
                "        mov     rax, qword [rbp-28H]\n" +
                "        mov     rdi, rax\n" +
                "        call    strlen\n" +
                "        mov     qword [rbp-18H], rax\n" +
                "        mov     rax, qword [rbp-30H]\n" +
                "        mov     rdi, rax\n" +
                "        call    strlen\n" +
                "        mov     qword [rbp-10H], rax\n" +
                "        mov     rdx, qword [rbp-18H]\n" +
                "        mov     rax, qword [rbp-10H]\n" +
                "        add     rax, rdx\n" +
                "        add     rax, 1\n" +
                "        mov     rdi, rax\n" +
                "        call    malloc\n" +
                "        mov     qword [rbp-8H], rax\n" +
                "        mov     rdx, qword [rbp-28H]\n" +
                "        mov     rax, qword [rbp-8H]\n" +
                "        mov     rsi, rdx\n" +
                "        mov     rdi, rax\n" +
                "        call    strcpy\n" +
                "        mov     rdx, qword [rbp-18H]\n" +
                "        mov     rax, qword [rbp-8H]\n" +
                "        add     rdx, rax\n" +
                "        mov     rax, qword [rbp-30H]\n" +
                "        mov     rsi, rax\n" +
                "        mov     rdi, rdx\n" +
                "        call    strcpy\n" +
                "        mov     rdx, qword [rbp-18H]\n" +
                "        mov     rax, qword [rbp-10H]\n" +
                "        add     rax, rdx\n" +
                "        mov     rdx, rax\n" +
                "        mov     rax, qword [rbp-8H]\n" +
                "        add     rax, rdx\n" +
                "        mov     byte [rax], 0\n" +
                "        mov     rax, qword [rbp-8H]\n" +
                "        leave\n" +
                "        ret\n" +
                "\n" +
                "\n" +
                "_string_less_func:\n" +
                "        push    rbp\n" +
                "        mov     rbp, rsp\n" +
                "        sub     rsp, 16\n" +
                "        mov     qword [rbp-8H], rdi\n" +
                "        mov     qword [rbp-10H], rsi\n" +
                "        mov     rdx, qword [rbp-10H]\n" +
                "        mov     rax, qword [rbp-8H]\n" +
                "        mov     rsi, rdx\n" +
                "        mov     rdi, rax\n" +
                "        call    strcmp\n" +
                "        shr     eax, 31\n" +
                "        leave\n" +
                "        ret\n" +
                "\n" +
                "\n" +
                "_string_lessequal_func:\n" +
                "        push    rbp\n" +
                "        mov     rbp, rsp\n" +
                "        sub     rsp, 16\n" +
                "        mov     qword [rbp-8H], rdi\n" +
                "        mov     qword [rbp-10H], rsi\n" +
                "        mov     rdx, qword [rbp-10H]\n" +
                "        mov     rax, qword [rbp-8H]\n" +
                "        mov     rsi, rdx\n" +
                "        mov     rdi, rax\n" +
                "        call    strcmp\n" +
                "        test    eax, eax\n" +
                "        setle   al\n" +
                "        leave\n" +
                "        ret\n" +
                "\n" +
                "\n" +
                "_string_great_func:\n" +
                "        push    rbp\n" +
                "        mov     rbp, rsp\n" +
                "        sub     rsp, 16\n" +
                "        mov     qword [rbp-8H], rdi\n" +
                "        mov     qword [rbp-10H], rsi\n" +
                "        mov     rdx, qword [rbp-10H]\n" +
                "        mov     rax, qword [rbp-8H]\n" +
                "        mov     rsi, rdx\n" +
                "        mov     rdi, rax\n" +
                "        call    strcmp\n" +
                "        test    eax, eax\n" +
                "        setg    al\n" +
                "        leave\n" +
                "        ret\n" +
                "\n" +
                "\n" +
                "_string_greaterequal_func:\n" +
                "        push    rbp\n" +
                "        mov     rbp, rsp\n" +
                "        sub     rsp, 16\n" +
                "        mov     qword [rbp-8H], rdi\n" +
                "        mov     qword [rbp-10H], rsi\n" +
                "        mov     rdx, qword [rbp-10H]\n" +
                "        mov     rax, qword [rbp-8H]\n" +
                "        mov     rsi, rdx\n" +
                "        mov     rdi, rax\n" +
                "        call    strcmp\n" +
                "        not     eax\n" +
                "        shr     eax, 31\n" +
                "        leave\n" +
                "        ret\n" +
                "\n" +
                "\n" +
                "_string_equal_func:\n" +
                "        push    rbp\n" +
                "        mov     rbp, rsp\n" +
                "        sub     rsp, 16\n" +
                "        mov     qword [rbp-8H], rdi\n" +
                "        mov     qword [rbp-10H], rsi\n" +
                "        mov     rdx, qword [rbp-10H]\n" +
                "        mov     rax, qword [rbp-8H]\n" +
                "        mov     rsi, rdx\n" +
                "        mov     rdi, rax\n" +
                "        call    strcmp\n" +
                "        test    eax, eax\n" +
                "        sete    al\n" +
                "        leave\n" +
                "        ret\n" +
                "\n" +
                "\n" +
                "_string_notequal_func:\n" +
                "        push    rbp\n" +
                "        mov     rbp, rsp\n" +
                "        sub     rsp, 16\n" +
                "        mov     qword [rbp-8H], rdi\n" +
                "        mov     qword [rbp-10H], rsi\n" +
                "        mov     rdx, qword [rbp-10H]\n" +
                "        mov     rax, qword [rbp-8H]\n" +
                "        mov     rsi, rdx\n" +
                "        mov     rdi, rax\n" +
                "        call    strcmp\n" +
                "        test    eax, eax\n" +
                "        setne   al\n" +
                "        leave\n" +
                "        ret\n" +
                "\n" +
                "\n" +
                "\n" +
                "SECTION .data   \n" +
                "\n" +
                "\n" +
                "SECTION .bss    \n" +
                "\n" +
                "\n" +
                "SECTION .rodata \n" +
                "\n" +
                "L_017:\n" +
                "        db 25H, 73H, 00H\n" +
                "\n" +
                "L_018:\n" +
                "        db 25H, 6CH, 64H, 00H\n" +
                "\n" +
                "\n");
    }
}
