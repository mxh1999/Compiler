package beta1.Trans;

public class preFuncTranslator {
    public static void addpreFunc(StringBuilder str) {
        str.append("SECTION .text\n" +
                "\n" +
                "_array_size_func:\n" +
                "        mov     rax, [rdi]\n" +
                "        ret");
        str.append("global main\n" +
                "SECTION .text\n" +
                "\n" +
                "_array_size_func:\n" +
                "        mov     rax, [rdi]\n" +
                "        ret\n" +
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
                "\n" +
                "section .text\n" +
                "main:\n" +
                "          push      rbp\n" +
                "          mov       rbp, rsp\n" +
                "Lab_1:\n" +
                "          call      main_func\n" +
                "          leave     \n" +
                "          ret       \n" +
                "\n" +
                "exchange_func:\n" +
                "          push      rbp\n" +
                "          mov       rbp, rsp\n" +
                "          sub       rsp, 208\n" +
                "          mov       qword [rbp-24], rdi\n" +
                "          mov       qword [rbp-16], rsi\n" +
                "Lab_2:\n" +
                "          mov       r10, qword [rbp-24]\n" +
                "          mov       qword [rbp-32], r10\n" +
                "          mov       r10, qword [@a_var]\n" +
                "          mov       qword [rbp-40], r10\n" +
                "          mov       r10, qword [rbp-32]\n" +
                "          imul      r10, 8\n" +
                "          mov       qword [rbp-48], r10\n" +
                "          mov       r10, qword [rbp-48]\n" +
                "          add       r10, 8\n" +
                "          mov       qword [rbp-56], r10\n" +
                "          mov       r10, qword [rbp-40]\n" +
                "          add       r10, qword [rbp-56]\n" +
                "          mov       qword [rbp-64], r10\n" +
                "          mov       r11, qword [rbp-64]\n" +
                "          mov       r10, [r11]\n" +
                "          mov       qword [rbp-72], r10\n" +
                "          mov       r10, qword [rbp-72]\n" +
                "          mov       qword [rbp-8], r10\n" +
                "          mov       r10, qword [rbp-24]\n" +
                "          mov       qword [rbp-80], r10\n" +
                "          mov       r10, qword [@a_var]\n" +
                "          mov       qword [rbp-88], r10\n" +
                "          mov       r10, qword [rbp-80]\n" +
                "          imul      r10, 8\n" +
                "          mov       qword [rbp-96], r10\n" +
                "          mov       r10, qword [rbp-96]\n" +
                "          add       r10, 8\n" +
                "          mov       qword [rbp-104], r10\n" +
                "          mov       r10, qword [rbp-88]\n" +
                "          add       r10, qword [rbp-104]\n" +
                "          mov       qword [rbp-112], r10\n" +
                "          mov       r10, qword [rbp-16]\n" +
                "          mov       qword [rbp-120], r10\n" +
                "          mov       r10, qword [@a_var]\n" +
                "          mov       qword [rbp-128], r10\n" +
                "          mov       r10, qword [rbp-120]\n" +
                "          imul      r10, 8\n" +
                "          mov       qword [rbp-136], r10\n" +
                "          mov       r10, qword [rbp-136]\n" +
                "          add       r10, 8\n" +
                "          mov       qword [rbp-144], r10\n" +
                "          mov       r10, qword [rbp-128]\n" +
                "          add       r10, qword [rbp-144]\n" +
                "          mov       qword [rbp-152], r10\n" +
                "          mov       r11, qword [rbp-152]\n" +
                "          mov       r10, [r11]\n" +
                "          mov       qword [rbp-160], r10\n" +
                "          mov       r10, qword [rbp-160]\n" +
                "          mov       r11, qword [rbp-112]\n" +
                "          mov       [r11], r10\n" +
                "          mov       r10, qword [rbp-16]\n" +
                "          mov       qword [rbp-168], r10\n" +
                "          mov       r10, qword [@a_var]\n" +
                "          mov       qword [rbp-176], r10\n" +
                "          mov       r10, qword [rbp-168]\n" +
                "          imul      r10, 8\n" +
                "          mov       qword [rbp-184], r10\n" +
                "          mov       r10, qword [rbp-184]\n" +
                "          add       r10, 8\n" +
                "          mov       qword [rbp-192], r10\n" +
                "          mov       r10, qword [rbp-176]\n" +
                "          add       r10, qword [rbp-192]\n" +
                "          mov       qword [rbp-200], r10\n" +
                "          mov       r10, qword [rbp-8]\n" +
                "          mov       qword [rbp-208], r10\n" +
                "          mov       r10, qword [rbp-208]\n" +
                "          mov       r11, qword [rbp-200]\n" +
                "          mov       [r11], r10\n" +
                "          leave     \n" +
                "          ret       \n" +
                "\n" +
                "makeHeap_func:\n" +
                "          push      rbp\n" +
                "          mov       rbp, rsp\n" +
                "          sub       rsp, 432\n" +
                "Lab_3:\n" +
                "          mov       r10, qword [@n_var]\n" +
                "          mov       qword [rbp-32], r10\n" +
                "          mov       r10, qword [rbp-32]\n" +
                "          sub       r10, 1\n" +
                "          mov       qword [rbp-40], r10\n" +
                "          xor       rdx, rdx\n" +
                "          mov       rax, qword [rbp-40]\n" +
                "          mov       r10, 2\n" +
                "          idiv      r10\n" +
                "          mov       qword [rbp-48], rax\n" +
                "          mov       r10, qword [rbp-48]\n" +
                "          mov       qword [rbp-24], r10\n" +
                "          mov       r10, 0\n" +
                "          mov       qword [rbp-16], r10\n" +
                "          mov       r10, 0\n" +
                "          mov       qword [rbp-8], r10\n" +
                "          jmp       Lab_4\n" +
                "Lab_4:\n" +
                "          mov       r10, qword [rbp-24]\n" +
                "          mov       qword [rbp-56], r10\n" +
                "          mov       r10, qword [rbp-56]\n" +
                "          xor       rax, rax\n" +
                "          cmp       r10, 0\n" +
                "          setge     al\n" +
                "          mov       qword [rbp-64], rax\n" +
                "          cmp       qword [rbp-64], 0\n" +
                "          jnz       Lab_5\n" +
                "          jmp       Lab_6\n" +
                "Lab_5:\n" +
                "          mov       r10, qword [rbp-24]\n" +
                "          mov       qword [rbp-72], r10\n" +
                "          mov       r10, qword [rbp-72]\n" +
                "          imul      r10, 2\n" +
                "          mov       qword [rbp-80], r10\n" +
                "          mov       r10, qword [rbp-80]\n" +
                "          mov       qword [rbp-8], r10\n" +
                "          jmp       Lab_7\n" +
                "Lab_6:\n" +
                "          mov       rax, 0\n" +
                "          leave     \n" +
                "          ret       \n" +
                "Lab_7:\n" +
                "          mov       r10, qword [rbp-24]\n" +
                "          mov       qword [rbp-88], r10\n" +
                "          mov       r10, qword [rbp-88]\n" +
                "          imul      r10, 2\n" +
                "          mov       qword [rbp-96], r10\n" +
                "          mov       r10, qword [rbp-96]\n" +
                "          add       r10, 1\n" +
                "          mov       qword [rbp-104], r10\n" +
                "          mov       r10, qword [@n_var]\n" +
                "          mov       qword [rbp-112], r10\n" +
                "          mov       r10, qword [rbp-104]\n" +
                "          xor       rax, rax\n" +
                "          cmp       r10, qword [rbp-112]\n" +
                "          setl      al\n" +
                "          mov       qword [rbp-120], rax\n" +
                "          mov       r10, qword [rbp-120]\n" +
                "          not       r10\n" +
                "          mov       qword [rbp-128], r10\n" +
                "          cmp       qword [rbp-128], 0\n" +
                "          jnz       Lab_12\n" +
                "          mov       r10, qword [rbp-24]\n" +
                "          mov       qword [rbp-136], r10\n" +
                "          mov       r10, qword [rbp-136]\n" +
                "          imul      r10, 2\n" +
                "          mov       qword [rbp-144], r10\n" +
                "          mov       r10, qword [rbp-144]\n" +
                "          add       r10, 1\n" +
                "          mov       qword [rbp-152], r10\n" +
                "          mov       r10, qword [@a_var]\n" +
                "          mov       qword [rbp-160], r10\n" +
                "          mov       r10, qword [rbp-152]\n" +
                "          imul      r10, 8\n" +
                "          mov       qword [rbp-168], r10\n" +
                "          mov       r10, qword [rbp-168]\n" +
                "          add       r10, 8\n" +
                "          mov       qword [rbp-176], r10\n" +
                "          mov       r10, qword [rbp-160]\n" +
                "          add       r10, qword [rbp-176]\n" +
                "          mov       qword [rbp-184], r10\n" +
                "          mov       r10, qword [rbp-24]\n" +
                "          mov       qword [rbp-192], r10\n" +
                "          mov       r10, qword [rbp-192]\n" +
                "          imul      r10, 2\n" +
                "          mov       qword [rbp-200], r10\n" +
                "          mov       r10, qword [@a_var]\n" +
                "          mov       qword [rbp-208], r10\n" +
                "          mov       r10, qword [rbp-200]\n" +
                "          imul      r10, 8\n" +
                "          mov       qword [rbp-216], r10\n" +
                "          mov       r10, qword [rbp-216]\n" +
                "          add       r10, 8\n" +
                "          mov       qword [rbp-224], r10\n" +
                "          mov       r10, qword [rbp-208]\n" +
                "          add       r10, qword [rbp-224]\n" +
                "          mov       qword [rbp-232], r10\n" +
                "          mov       r11, qword [rbp-184]\n" +
                "          mov       r10, [r11]\n" +
                "          mov       qword [rbp-240], r10\n" +
                "          mov       r11, qword [rbp-232]\n" +
                "          mov       r10, [r11]\n" +
                "          mov       qword [rbp-248], r10\n" +
                "          mov       r10, qword [rbp-240]\n" +
                "          xor       rax, rax\n" +
                "          cmp       r10, qword [rbp-248]\n" +
                "          setl      al\n" +
                "          mov       qword [rbp-256], rax\n" +
                "          mov       r10, qword [rbp-256]\n" +
                "          mov       qword [rbp-264], r9\n" +
                "          jmp       Lab_11\n" +
                "Lab_8:\n" +
                "          mov       r10, qword [rbp-24]\n" +
                "          mov       qword [rbp-272], r10\n" +
                "          mov       r10, qword [rbp-272]\n" +
                "          imul      r10, 2\n" +
                "          mov       qword [rbp-280], r10\n" +
                "          mov       r10, qword [rbp-280]\n" +
                "          add       r10, 1\n" +
                "          mov       qword [rbp-288], r10\n" +
                "          mov       r10, qword [rbp-288]\n" +
                "          mov       qword [rbp-8], r10\n" +
                "Lab_9:\n" +
                "Lab_10:\n" +
                "          jmp       Lab_13\n" +
                "Lab_11:\n" +
                "          cmp       qword [rbp-264], 0\n" +
                "          jnz       Lab_8\n" +
                "          jmp       Lab_9\n" +
                "Lab_12:\n" +
                "          mov       qword [rbp-264], 0\n" +
                "          jmp       Lab_11\n" +
                "Lab_13:\n" +
                "          mov       r10, qword [rbp-24]\n" +
                "          mov       qword [rbp-296], r10\n" +
                "          mov       r10, qword [@a_var]\n" +
                "          mov       qword [rbp-304], r10\n" +
                "          mov       r10, qword [rbp-296]\n" +
                "          imul      r10, 8\n" +
                "          mov       qword [rbp-312], r10\n" +
                "          mov       r10, qword [rbp-312]\n" +
                "          add       r10, 8\n" +
                "          mov       qword [rbp-320], r10\n" +
                "          mov       r10, qword [rbp-304]\n" +
                "          add       r10, qword [rbp-320]\n" +
                "          mov       qword [rbp-328], r10\n" +
                "          mov       r10, qword [rbp-8]\n" +
                "          mov       qword [rbp-336], r10\n" +
                "          mov       r10, qword [@a_var]\n" +
                "          mov       qword [rbp-344], r10\n" +
                "          mov       r10, qword [rbp-336]\n" +
                "          imul      r10, 8\n" +
                "          mov       qword [rbp-352], r10\n" +
                "          mov       r10, qword [rbp-352]\n" +
                "          add       r10, 8\n" +
                "          mov       qword [rbp-360], r10\n" +
                "          mov       r10, qword [rbp-344]\n" +
                "          add       r10, qword [rbp-360]\n" +
                "          mov       qword [rbp-368], r10\n" +
                "          mov       r11, qword [rbp-328]\n" +
                "          mov       r10, [r11]\n" +
                "          mov       qword [rbp-376], r10\n" +
                "          mov       r11, qword [rbp-368]\n" +
                "          mov       r10, [r11]\n" +
                "          mov       qword [rbp-384], r10\n" +
                "          mov       r10, qword [rbp-376]\n" +
                "          xor       rax, rax\n" +
                "          cmp       r10, qword [rbp-384]\n" +
                "          setg      al\n" +
                "          mov       qword [rbp-392], rax\n" +
                "          cmp       qword [rbp-392], 0\n" +
                "          jnz       Lab_14\n" +
                "          jmp       Lab_15\n" +
                "Lab_14:\n" +
                "          mov       r10, qword [rbp-24]\n" +
                "          mov       qword [rbp-400], r10\n" +
                "          mov       r10, qword [rbp-8]\n" +
                "          mov       qword [rbp-408], r10\n" +
                "          mov       rdi, qword [rbp-400]\n" +
                "          mov       rsi, qword [rbp-408]\n" +
                "          call      exchange_func\n" +
                "Lab_15:\n" +
                "Lab_16:\n" +
                "          mov       r10, qword [rbp-24]\n" +
                "          mov       qword [rbp-416], r10\n" +
                "          mov       r10, qword [rbp-416]\n" +
                "          sub       r10, 1\n" +
                "          mov       qword [rbp-424], r10\n" +
                "          mov       r10, qword [rbp-424]\n" +
                "          mov       qword [rbp-24], r10\n" +
                "          jmp       Lab_4\n" +
                "          leave     \n" +
                "          ret       \n" +
                "\n" +
                "adjustHeap_func:\n" +
                "          push      rbp\n" +
                "          mov       rbp, rsp\n" +
                "          sub       rsp, 592\n" +
                "          mov       qword [rbp-40], rdi\n" +
                "Lab_17:\n" +
                "          mov       r10, 0\n" +
                "          mov       qword [rbp-32], r10\n" +
                "          mov       r10, 0\n" +
                "          mov       qword [rbp-24], r10\n" +
                "          mov       r10, 0\n" +
                "          mov       qword [rbp-16], r10\n" +
                "          jmp       Lab_18\n" +
                "Lab_18:\n" +
                "          mov       r10, qword [rbp-32]\n" +
                "          mov       qword [rbp-48], r10\n" +
                "          mov       r10, qword [rbp-48]\n" +
                "          imul      r10, 2\n" +
                "          mov       qword [rbp-56], r10\n" +
                "          mov       r10, qword [rbp-40]\n" +
                "          mov       qword [rbp-64], r10\n" +
                "          mov       r10, qword [rbp-56]\n" +
                "          xor       rax, rax\n" +
                "          cmp       r10, qword [rbp-64]\n" +
                "          setl      al\n" +
                "          mov       qword [rbp-72], rax\n" +
                "          cmp       qword [rbp-72], 0\n" +
                "          jnz       Lab_19\n" +
                "          jmp       Lab_20\n" +
                "Lab_19:\n" +
                "          mov       r10, qword [rbp-32]\n" +
                "          mov       qword [rbp-80], r10\n" +
                "          mov       r10, qword [rbp-80]\n" +
                "          imul      r10, 2\n" +
                "          mov       qword [rbp-88], r10\n" +
                "          mov       r10, qword [rbp-88]\n" +
                "          mov       qword [rbp-24], r10\n" +
                "          jmp       Lab_21\n" +
                "Lab_20:\n" +
                "          mov       rax, 0\n" +
                "          leave     \n" +
                "          ret       \n" +
                "Lab_21:\n" +
                "          mov       r10, qword [rbp-32]\n" +
                "          mov       qword [rbp-96], r10\n" +
                "          mov       r10, qword [rbp-96]\n" +
                "          imul      r10, 2\n" +
                "          mov       qword [rbp-104], r10\n" +
                "          mov       r10, qword [rbp-104]\n" +
                "          add       r10, 1\n" +
                "          mov       qword [rbp-112], r10\n" +
                "          mov       r10, qword [rbp-40]\n" +
                "          mov       qword [rbp-120], r10\n" +
                "          mov       r10, qword [rbp-112]\n" +
                "          xor       rax, rax\n" +
                "          cmp       r10, qword [rbp-120]\n" +
                "          setl      al\n" +
                "          mov       qword [rbp-128], rax\n" +
                "          mov       r10, qword [rbp-128]\n" +
                "          not       r10\n" +
                "          mov       qword [rbp-136], r10\n" +
                "          cmp       qword [rbp-136], 0\n" +
                "          jnz       Lab_26\n" +
                "          mov       r10, qword [rbp-32]\n" +
                "          mov       qword [rbp-144], r10\n" +
                "          mov       r10, qword [rbp-144]\n" +
                "          imul      r10, 2\n" +
                "          mov       qword [rbp-152], r10\n" +
                "          mov       r10, qword [rbp-152]\n" +
                "          add       r10, 1\n" +
                "          mov       qword [rbp-160], r10\n" +
                "          mov       r10, qword [@a_var]\n" +
                "          mov       qword [rbp-168], r10\n" +
                "          mov       r10, qword [rbp-160]\n" +
                "          imul      r10, 8\n" +
                "          mov       qword [rbp-176], r10\n" +
                "          mov       r10, qword [rbp-176]\n" +
                "          add       r10, 8\n" +
                "          mov       qword [rbp-184], r10\n" +
                "          mov       r10, qword [rbp-168]\n" +
                "          add       r10, qword [rbp-184]\n" +
                "          mov       qword [rbp-192], r10\n" +
                "          mov       r10, qword [rbp-32]\n" +
                "          mov       qword [rbp-200], r10\n" +
                "          mov       r10, qword [rbp-200]\n" +
                "          imul      r10, 2\n" +
                "          mov       qword [rbp-208], r10\n" +
                "          mov       r10, qword [@a_var]\n" +
                "          mov       qword [rbp-216], r10\n" +
                "          mov       r10, qword [rbp-208]\n" +
                "          imul      r10, 8\n" +
                "          mov       qword [rbp-224], r10\n" +
                "          mov       r10, qword [rbp-224]\n" +
                "          add       r10, 8\n" +
                "          mov       qword [rbp-232], r10\n" +
                "          mov       r10, qword [rbp-216]\n" +
                "          add       r10, qword [rbp-232]\n" +
                "          mov       qword [rbp-240], r10\n" +
                "          mov       r11, qword [rbp-192]\n" +
                "          mov       r10, [r11]\n" +
                "          mov       qword [rbp-248], r10\n" +
                "          mov       r11, qword [rbp-240]\n" +
                "          mov       r10, [r11]\n" +
                "          mov       qword [rbp-256], r10\n" +
                "          mov       r10, qword [rbp-248]\n" +
                "          xor       rax, rax\n" +
                "          cmp       r10, qword [rbp-256]\n" +
                "          setl      al\n" +
                "          mov       qword [rbp-264], rax\n" +
                "          mov       r10, qword [rbp-264]\n" +
                "          mov       qword [rbp-272], r9\n" +
                "          jmp       Lab_25\n" +
                "Lab_22:\n" +
                "          mov       r10, qword [rbp-32]\n" +
                "          mov       qword [rbp-280], r10\n" +
                "          mov       r10, qword [rbp-280]\n" +
                "          imul      r10, 2\n" +
                "          mov       qword [rbp-288], r10\n" +
                "          mov       r10, qword [rbp-288]\n" +
                "          add       r10, 1\n" +
                "          mov       qword [rbp-296], r10\n" +
                "          mov       r10, qword [rbp-296]\n" +
                "          mov       qword [rbp-24], r10\n" +
                "Lab_23:\n" +
                "Lab_24:\n" +
                "          jmp       Lab_27\n" +
                "Lab_25:\n" +
                "          cmp       qword [rbp-272], 0\n" +
                "          jnz       Lab_22\n" +
                "          jmp       Lab_23\n" +
                "Lab_26:\n" +
                "          mov       qword [rbp-272], 0\n" +
                "          jmp       Lab_25\n" +
                "Lab_27:\n" +
                "          mov       r10, qword [rbp-32]\n" +
                "          mov       qword [rbp-304], r10\n" +
                "          mov       r10, qword [@a_var]\n" +
                "          mov       qword [rbp-312], r10\n" +
                "          mov       r10, qword [rbp-304]\n" +
                "          imul      r10, 8\n" +
                "          mov       qword [rbp-320], r10\n" +
                "          mov       r10, qword [rbp-320]\n" +
                "          add       r10, 8\n" +
                "          mov       qword [rbp-328], r10\n" +
                "          mov       r10, qword [rbp-312]\n" +
                "          add       r10, qword [rbp-328]\n" +
                "          mov       qword [rbp-336], r10\n" +
                "          mov       r10, qword [rbp-24]\n" +
                "          mov       qword [rbp-344], r10\n" +
                "          mov       r10, qword [@a_var]\n" +
                "          mov       qword [rbp-352], r10\n" +
                "          mov       r10, qword [rbp-344]\n" +
                "          imul      r10, 8\n" +
                "          mov       qword [rbp-360], r10\n" +
                "          mov       r10, qword [rbp-360]\n" +
                "          add       r10, 8\n" +
                "          mov       qword [rbp-368], r10\n" +
                "          mov       r10, qword [rbp-352]\n" +
                "          add       r10, qword [rbp-368]\n" +
                "          mov       qword [rbp-376], r10\n" +
                "          mov       r11, qword [rbp-336]\n" +
                "          mov       r10, [r11]\n" +
                "          mov       qword [rbp-384], r10\n" +
                "          mov       r11, qword [rbp-376]\n" +
                "          mov       r10, [r11]\n" +
                "          mov       qword [rbp-392], r10\n" +
                "          mov       r10, qword [rbp-384]\n" +
                "          xor       rax, rax\n" +
                "          cmp       r10, qword [rbp-392]\n" +
                "          setg      al\n" +
                "          mov       qword [rbp-400], rax\n" +
                "          cmp       qword [rbp-400], 0\n" +
                "          jnz       Lab_28\n" +
                "          jmp       Lab_29\n" +
                "Lab_28:\n" +
                "          mov       r10, qword [rbp-32]\n" +
                "          mov       qword [rbp-408], r10\n" +
                "          mov       r10, qword [@a_var]\n" +
                "          mov       qword [rbp-416], r10\n" +
                "          mov       r10, qword [rbp-408]\n" +
                "          imul      r10, 8\n" +
                "          mov       qword [rbp-424], r10\n" +
                "          mov       r10, qword [rbp-424]\n" +
                "          add       r10, 8\n" +
                "          mov       qword [rbp-432], r10\n" +
                "          mov       r10, qword [rbp-416]\n" +
                "          add       r10, qword [rbp-432]\n" +
                "          mov       qword [rbp-440], r10\n" +
                "          mov       r11, qword [rbp-440]\n" +
                "          mov       r10, [r11]\n" +
                "          mov       qword [rbp-448], r10\n" +
                "          mov       r10, qword [rbp-448]\n" +
                "          mov       qword [rbp-8], r10\n" +
                "          mov       r10, qword [rbp-32]\n" +
                "          mov       qword [rbp-456], r10\n" +
                "          mov       r10, qword [@a_var]\n" +
                "          mov       qword [rbp-464], r10\n" +
                "          mov       r10, qword [rbp-456]\n" +
                "          imul      r10, 8\n" +
                "          mov       qword [rbp-472], r10\n" +
                "          mov       r10, qword [rbp-472]\n" +
                "          add       r10, 8\n" +
                "          mov       qword [rbp-480], r10\n" +
                "          mov       r10, qword [rbp-464]\n" +
                "          add       r10, qword [rbp-480]\n" +
                "          mov       qword [rbp-488], r10\n" +
                "          mov       r10, qword [rbp-24]\n" +
                "          mov       qword [rbp-496], r10\n" +
                "          mov       r10, qword [@a_var]\n" +
                "          mov       qword [rbp-504], r10\n" +
                "          mov       r10, qword [rbp-496]\n" +
                "          imul      r10, 8\n" +
                "          mov       qword [rbp-512], r10\n" +
                "          mov       r10, qword [rbp-512]\n" +
                "          add       r10, 8\n" +
                "          mov       qword [rbp-520], r10\n" +
                "          mov       r10, qword [rbp-504]\n" +
                "          add       r10, qword [rbp-520]\n" +
                "          mov       qword [rbp-528], r10\n" +
                "          mov       r11, qword [rbp-528]\n" +
                "          mov       r10, [r11]\n" +
                "          mov       qword [rbp-536], r10\n" +
                "          mov       r10, qword [rbp-536]\n" +
                "          mov       r11, qword [rbp-488]\n" +
                "          mov       [r11], r10\n" +
                "          mov       r10, qword [rbp-24]\n" +
                "          mov       qword [rbp-544], r10\n" +
                "          mov       r10, qword [@a_var]\n" +
                "          mov       qword [rbp-552], r10\n" +
                "          mov       r10, qword [rbp-544]\n" +
                "          imul      r10, 8\n" +
                "          mov       qword [rbp-560], r10\n" +
                "          mov       r10, qword [rbp-560]\n" +
                "          add       r10, 8\n" +
                "          mov       qword [rbp-568], r10\n" +
                "          mov       r10, qword [rbp-552]\n" +
                "          add       r10, qword [rbp-568]\n" +
                "          mov       qword [rbp-576], r10\n" +
                "          mov       r10, qword [rbp-8]\n" +
                "          mov       qword [rbp-584], r10\n" +
                "          mov       r10, qword [rbp-584]\n" +
                "          mov       r11, qword [rbp-576]\n" +
                "          mov       [r11], r10\n" +
                "          mov       r10, qword [rbp-24]\n" +
                "          mov       qword [rbp-592], r10\n" +
                "          mov       r10, qword [rbp-592]\n" +
                "          mov       qword [rbp-32], r10\n" +
                "Lab_29:\n" +
                "          jmp       Lab_20\n" +
                "Lab_30:\n" +
                "          jmp       Lab_18\n" +
                "          leave     \n" +
                "          ret       \n" +
                "\n" +
                "heapSort_func:\n" +
                "          push      rbp\n" +
                "          mov       rbp, rsp\n" +
                "          sub       rsp, 320\n" +
                "Lab_31:\n" +
                "          mov       r10, 0\n" +
                "          mov       qword [rbp-16], r10\n" +
                "          mov       r10, 0\n" +
                "          mov       qword [rbp-8], r10\n" +
                "          jmp       Lab_32\n" +
                "Lab_32:\n" +
                "          mov       r10, qword [rbp-8]\n" +
                "          mov       qword [rbp-24], r10\n" +
                "          mov       r10, qword [@n_var]\n" +
                "          mov       qword [rbp-32], r10\n" +
                "          mov       r10, qword [rbp-24]\n" +
                "          xor       rax, rax\n" +
                "          cmp       r10, qword [rbp-32]\n" +
                "          setl      al\n" +
                "          mov       qword [rbp-40], rax\n" +
                "          cmp       qword [rbp-40], 0\n" +
                "          jnz       Lab_33\n" +
                "          jmp       Lab_34\n" +
                "Lab_33:\n" +
                "          mov       r10, qword [@a_var]\n" +
                "          mov       qword [rbp-48], r10\n" +
                "          mov       r10, 0\n" +
                "          imul      r10, 8\n" +
                "          mov       qword [rbp-56], r10\n" +
                "          mov       r10, qword [rbp-56]\n" +
                "          add       r10, 8\n" +
                "          mov       qword [rbp-64], r10\n" +
                "          mov       r10, qword [rbp-48]\n" +
                "          add       r10, qword [rbp-64]\n" +
                "          mov       qword [rbp-72], r10\n" +
                "          mov       r11, qword [rbp-72]\n" +
                "          mov       r10, [r11]\n" +
                "          mov       qword [rbp-80], r10\n" +
                "          mov       r10, qword [rbp-80]\n" +
                "          mov       qword [rbp-16], r10\n" +
                "          mov       r10, qword [@a_var]\n" +
                "          mov       qword [rbp-88], r10\n" +
                "          mov       r10, 0\n" +
                "          imul      r10, 8\n" +
                "          mov       qword [rbp-96], r10\n" +
                "          mov       r10, qword [rbp-96]\n" +
                "          add       r10, 8\n" +
                "          mov       qword [rbp-104], r10\n" +
                "          mov       r10, qword [rbp-88]\n" +
                "          add       r10, qword [rbp-104]\n" +
                "          mov       qword [rbp-112], r10\n" +
                "          mov       r10, qword [@n_var]\n" +
                "          mov       qword [rbp-120], r10\n" +
                "          mov       r10, qword [rbp-8]\n" +
                "          mov       qword [rbp-128], r10\n" +
                "          mov       r10, qword [rbp-120]\n" +
                "          sub       r10, qword [rbp-128]\n" +
                "          mov       qword [rbp-136], r10\n" +
                "          mov       r10, qword [rbp-136]\n" +
                "          sub       r10, 1\n" +
                "          mov       qword [rbp-144], r10\n" +
                "          mov       r10, qword [@a_var]\n" +
                "          mov       qword [rbp-152], r10\n" +
                "          mov       r10, qword [rbp-144]\n" +
                "          imul      r10, 8\n" +
                "          mov       qword [rbp-160], r10\n" +
                "          mov       r10, qword [rbp-160]\n" +
                "          add       r10, 8\n" +
                "          mov       qword [rbp-168], r10\n" +
                "          mov       r10, qword [rbp-152]\n" +
                "          add       r10, qword [rbp-168]\n" +
                "          mov       qword [rbp-176], r10\n" +
                "          mov       r11, qword [rbp-176]\n" +
                "          mov       r10, [r11]\n" +
                "          mov       qword [rbp-184], r10\n" +
                "          mov       r10, qword [rbp-184]\n" +
                "          mov       r11, qword [rbp-112]\n" +
                "          mov       [r11], r10\n" +
                "          mov       r10, qword [@n_var]\n" +
                "          mov       qword [rbp-192], r10\n" +
                "          mov       r10, qword [rbp-8]\n" +
                "          mov       qword [rbp-200], r10\n" +
                "          mov       r10, qword [rbp-192]\n" +
                "          sub       r10, qword [rbp-200]\n" +
                "          mov       qword [rbp-208], r10\n" +
                "          mov       r10, qword [rbp-208]\n" +
                "          sub       r10, 1\n" +
                "          mov       qword [rbp-216], r10\n" +
                "          mov       r10, qword [@a_var]\n" +
                "          mov       qword [rbp-224], r10\n" +
                "          mov       r10, qword [rbp-216]\n" +
                "          imul      r10, 8\n" +
                "          mov       qword [rbp-232], r10\n" +
                "          mov       r10, qword [rbp-232]\n" +
                "          add       r10, 8\n" +
                "          mov       qword [rbp-240], r10\n" +
                "          mov       r10, qword [rbp-224]\n" +
                "          add       r10, qword [rbp-240]\n" +
                "          mov       qword [rbp-248], r10\n" +
                "          mov       r10, qword [rbp-16]\n" +
                "          mov       qword [rbp-256], r10\n" +
                "          mov       r10, qword [rbp-256]\n" +
                "          mov       r11, qword [rbp-248]\n" +
                "          mov       [r11], r10\n" +
                "          mov       r10, qword [@n_var]\n" +
                "          mov       qword [rbp-264], r10\n" +
                "          mov       r10, qword [rbp-8]\n" +
                "          mov       qword [rbp-272], r10\n" +
                "          mov       r10, qword [rbp-264]\n" +
                "          sub       r10, qword [rbp-272]\n" +
                "          mov       qword [rbp-280], r10\n" +
                "          mov       r10, qword [rbp-280]\n" +
                "          sub       r10, 1\n" +
                "          mov       qword [rbp-288], r10\n" +
                "          mov       rdi, qword [rbp-288]\n" +
                "          call      adjustHeap_func\n" +
                "          mov       qword [rbp-296], rax\n" +
                "          mov       r10, qword [rbp-8]\n" +
                "          mov       qword [rbp-304], r10\n" +
                "          mov       r10, qword [rbp-304]\n" +
                "          add       r10, 1\n" +
                "          mov       qword [rbp-312], r10\n" +
                "          mov       r10, qword [rbp-312]\n" +
                "          mov       qword [rbp-8], r10\n" +
                "          jmp       Lab_32\n" +
                "Lab_34:\n" +
                "          mov       rax, 0\n" +
                "          leave     \n" +
                "          ret       \n" +
                "          leave     \n" +
                "          ret       \n" +
                "\n" +
                "main_func:\n" +
                "          push      rbp\n" +
                "          mov       rbp, rsp\n" +
                "          sub       rsp, 288\n" +
                "Lab_35:\n" +
                "          call      getString_func\n" +
                "          mov       qword [rbp-16], rax\n" +
                "          mov       rdi, qword [rbp-16]\n" +
                "          call      _string_parseInt_func\n" +
                "          mov       qword [rbp-24], rax\n" +
                "          mov       r10, qword [rbp-24]\n" +
                "          mov       qword [@n_var], r10\n" +
                "          mov       r10, qword [@n_var]\n" +
                "          mov       qword [rbp-32], r10\n" +
                "          mov       r10, qword [rbp-32]\n" +
                "          imul      r10, 8\n" +
                "          mov       qword [rbp-40], r10\n" +
                "          mov       r10, qword [rbp-40]\n" +
                "          add       r10, 8\n" +
                "          mov       qword [rbp-48], r10\n" +
                "          mov       rdi, qword [rbp-48]\n" +
                "          call      malloc\n" +
                "          mov       qword [rbp-56], rax\n" +
                "          mov       r10, qword [rbp-32]\n" +
                "          mov       r11, qword [rbp-56]\n" +
                "          mov       [r11], r10\n" +
                "          mov       r10, qword [rbp-56]\n" +
                "          mov       qword [@a_var], r10\n" +
                "          mov       r10, 0\n" +
                "          mov       qword [rbp-8], r10\n" +
                "          jmp       Lab_36\n" +
                "Lab_36:\n" +
                "          mov       r10, qword [@a_var]\n" +
                "          mov       qword [rbp-64], r10\n" +
                "          mov       rdi, qword [rbp-64]\n" +
                "          call      _array_size_func\n" +
                "          mov       qword [rbp-72], rax\n" +
                "          mov       r10, qword [rbp-8]\n" +
                "          mov       qword [rbp-80], r10\n" +
                "          mov       r10, qword [rbp-80]\n" +
                "          xor       rax, rax\n" +
                "          cmp       r10, qword [rbp-72]\n" +
                "          setl      al\n" +
                "          mov       qword [rbp-88], rax\n" +
                "          cmp       qword [rbp-88], 0\n" +
                "          jnz       Lab_37\n" +
                "          jmp       Lab_38\n" +
                "Lab_37:\n" +
                "          mov       r10, qword [rbp-8]\n" +
                "          mov       qword [rbp-96], r10\n" +
                "          mov       r10, qword [@a_var]\n" +
                "          mov       qword [rbp-104], r10\n" +
                "          mov       r10, qword [rbp-96]\n" +
                "          imul      r10, 8\n" +
                "          mov       qword [rbp-112], r10\n" +
                "          mov       r10, qword [rbp-112]\n" +
                "          add       r10, 8\n" +
                "          mov       qword [rbp-120], r10\n" +
                "          mov       r10, qword [rbp-104]\n" +
                "          add       r10, qword [rbp-120]\n" +
                "          mov       qword [rbp-128], r10\n" +
                "          mov       r10, qword [rbp-8]\n" +
                "          mov       qword [rbp-136], r10\n" +
                "          mov       r10, qword [rbp-136]\n" +
                "          mov       r11, qword [rbp-128]\n" +
                "          mov       [r11], r10\n" +
                "          mov       r10, qword [rbp-8]\n" +
                "          mov       qword [rbp-144], r10\n" +
                "          mov       r10, qword [rbp-144]\n" +
                "          add       r10, 1\n" +
                "          mov       qword [rbp-152], r10\n" +
                "          mov       r10, qword [rbp-152]\n" +
                "          mov       qword [rbp-8], r10\n" +
                "          jmp       Lab_36\n" +
                "Lab_38:\n" +
                "          call      makeHeap_func\n" +
                "          mov       qword [rbp-160], rax\n" +
                "          call      heapSort_func\n" +
                "          mov       qword [rbp-168], rax\n" +
                "          mov       r10, 0\n" +
                "          mov       qword [rbp-8], r10\n" +
                "          jmp       Lab_39\n" +
                "Lab_39:\n" +
                "          mov       r10, qword [@a_var]\n" +
                "          mov       qword [rbp-176], r10\n" +
                "          mov       rdi, qword [rbp-176]\n" +
                "          call      _array_size_func\n" +
                "          mov       qword [rbp-184], rax\n" +
                "          mov       r10, qword [rbp-8]\n" +
                "          mov       qword [rbp-192], r10\n" +
                "          mov       r10, qword [rbp-192]\n" +
                "          xor       rax, rax\n" +
                "          cmp       r10, qword [rbp-184]\n" +
                "          setl      al\n" +
                "          mov       qword [rbp-200], rax\n" +
                "          cmp       qword [rbp-200], 0\n" +
                "          jnz       Lab_40\n" +
                "          jmp       Lab_41\n" +
                "Lab_40:\n" +
                "          mov       r10, qword [rbp-8]\n" +
                "          mov       qword [rbp-208], r10\n" +
                "          mov       r10, qword [@a_var]\n" +
                "          mov       qword [rbp-216], r10\n" +
                "          mov       r10, qword [rbp-208]\n" +
                "          imul      r10, 8\n" +
                "          mov       qword [rbp-224], r10\n" +
                "          mov       r10, qword [rbp-224]\n" +
                "          add       r10, 8\n" +
                "          mov       qword [rbp-232], r10\n" +
                "          mov       r10, qword [rbp-216]\n" +
                "          add       r10, qword [rbp-232]\n" +
                "          mov       qword [rbp-240], r10\n" +
                "          mov       r11, qword [rbp-240]\n" +
                "          mov       r10, [r11]\n" +
                "          mov       qword [rbp-248], r10\n" +
                "          mov       rdi, qword [rbp-248]\n" +
                "          call      toString_func\n" +
                "          mov       qword [rbp-256], rax\n" +
                "          mov       rdi, qword [rbp-256]\n" +
                "          mov       rsi, const_1_cs\n" +
                "          call      _string_add_func\n" +
                "          mov       qword [rbp-264], rax\n" +
                "          mov       rdi, qword [rbp-264]\n" +
                "          call      print_func\n" +
                "          mov       r10, qword [rbp-8]\n" +
                "          mov       qword [rbp-272], r10\n" +
                "          mov       r10, qword [rbp-272]\n" +
                "          add       r10, 1\n" +
                "          mov       qword [rbp-280], r10\n" +
                "          mov       r10, qword [rbp-280]\n" +
                "          mov       qword [rbp-8], r10\n" +
                "          jmp       Lab_39\n" +
                "Lab_41:\n" +
                "          mov       rdi, const_2_cs\n" +
                "          call      print_func\n" +
                "          mov       rax, 0\n" +
                "          leave     \n" +
                "          ret       \n" +
                "          leave     \n" +
                "          ret       \n" +
                "\n" +
                "\n" +
                "section .data\n" +
                "const_1_cs:\n" +
                "          db        32,0     ; \n" +
                "const_2_cs:\n" +
                "          db        10,0     ;\\n\n" +
                "section .bss\n" +
                "@n_var:\n" +
                "          resb      8\n" +
                "@a_var:\n" +
                "          resb      8\n");
    }
}
